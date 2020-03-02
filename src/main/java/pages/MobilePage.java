package pages;

import static utils.Util.WebClient.getWebClientInstance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.google.gson.Gson;

import domain.Lote;
import domain.Pedido;
import domain.Separacao;
import domain.SeparacaoItem;
import domain.UserMobile;
import utils.Util.WebClient;

public class MobilePage {

	private final String IP_SERVIDOR = "http://192.168.150.116"; // DESENVOLVIMENTO

//	private final String IP_SERVIDOR = "http://192.168.151.47"; // HOMOLOGAÇÃO

	private final String CODIGO_USUARIO = "555";

	private final String HOST = "/SELENIUM";

	private final WebDriver NAVEGADOR;

	private final WebClient WEB_CLIENT;

	private UserMobile user;

	private Separacao separacao;

	public MobilePage(WebDriver navegador) {
		this.NAVEGADOR = navegador;
		WEB_CLIENT = getWebClientInstance(IP_SERVIDOR);
	}

	public void login() {

		String endPoint = "/pmz/mobileEstoquista/index.php/acesso/LoginController/LoginUsuario/%s/%s";

		NAVEGADOR.get(getUrl(endPoint, CODIGO_USUARIO, HOST));

		this.getUser("body");
	}

	public void realizaSeparacao(String controle) {

		this.login();
		this.getSeparacao();
		this.enviaLotes(controle);
	}

	private void enviaLotes(String controle) {

		this.separacao.getPedido().parallelStream().filter(p -> p.getCodigo().equals(controle))
				.forEach(pedidoFiltrado -> {

					enviaLote(pedidoFiltrado);
				});
	}

	private void enviaLote(Pedido pedido) {

		SeparacaoItem item = getItem(pedido.getCodigo());

		List<Lote> lotes = preparaLotes(pedido, item);

		String endPoint = "pmz/mobileEstoquista/index.php/separacao/Lotes";

		Map<String, String> query = new HashMap<>();
		query.put("chave", user.getChave());

		MultivaluedMap<String, String> values = new MultivaluedHashMap<String, String>();
		values.add("lote", new Gson().toJson(lotes));

		String response = WEB_CLIENT.setQuery(query).sendPostRequest(endPoint, values);

		System.out.println(response);
	}

	private List<Lote> preparaLotes(Pedido pedido, SeparacaoItem item) {

		List<Lote> lotes = new ArrayList<Lote>();

		final String REGISTRO = "0010";

		final String PATTERN = "%s|%s|%s|%s|%s|%s";

		item.getItens().forEach(i -> {

			i.setQtd_sep(i.getQtd_ped());

			lotes.add(new Lote(System.currentTimeMillis(), REGISTRO,
					String.format(PATTERN, pedido.getOrcamento(), i.getCodBarra().get(0).getBarras(), i.getCodigo(),
							user.getFilial(), user.getUsuario_nome(), i.getQtd_sep())));
		});

		lotes.add(new Lote(System.currentTimeMillis(), "0008",
				String.format("%s|%s|%s", user.getFilial(), pedido.getCodigo(), user.getUsuario_nome())));

		return lotes;
	}

	private SeparacaoItem getItem(String controle) {

		String endPoint = "/pmz/mobileEstoquista/index.php/separacao/Itens?xfilial=%s&xid_est=%s&xcontrole=%s&chave=%s";

		NAVEGADOR.get(getUrl(endPoint, user.getFilial(), user.getUsuario_codigo(), controle, user.getChave()));

		return this.getSeparacaoItem("body > pre");
	}

	private void getSeparacao() {

		String endPoint = "/pmz/mobileEstoquista/index.php/separacao/Pedidos?xfilial=%s&xid_est=%s&chave=%s";

		String url = getUrl(endPoint, user.getFilial(), user.getUsuario_codigo(), user.getChave());

		NAVEGADOR.get(url);

		getSeparacao("body > pre");
	}

	private String getUrl(String endpoint, Object... params) {

		return String.format(IP_SERVIDOR + endpoint, params);
	}

	private Object getObject(String cssSelector, Class<?> clazz) {

		Gson decoder = new Gson();

		String json = NAVEGADOR.findElement(By.cssSelector(cssSelector)).getAttribute("innerHTML");

		return decoder.fromJson(json, clazz);
	}

	private void getSeparacao(String cssSelector) {

		this.separacao = (Separacao) getObject(cssSelector, Separacao.class);
	}

	private void getUser(String cssSelector) {

		this.user = (UserMobile) getObject(cssSelector, UserMobile.class);
	}

	private SeparacaoItem getSeparacaoItem(String cssSelector) {

		return (SeparacaoItem) getObject(cssSelector, SeparacaoItem.class);
	}

	@Override
	protected void finalize() throws Throwable {

		NAVEGADOR.quit();
		super.finalize();
	}
}
