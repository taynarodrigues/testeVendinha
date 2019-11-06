package query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;

import conexao.ConexaoBanco;

public class QueryVendas {

	private static Connection connection;
	private static Statement consulta;
	private static String filial = "34";

	@Before
	public static void inicializa() throws ClassNotFoundException, SQLException {

		connection = ConexaoBanco.criarConexao();
		consulta = connection.createStatement();
	}

	@After
	public static void closeConexao() throws SQLException {

		connection = ConexaoBanco.closeConnection();
	}

	public static void pedcontrole_CFF() throws ClassNotFoundException, SQLException {

		inicializa();

		String query = "update pedcontrole set status ='CFF',vendedor = 1 where log_data > '01/01/2018' and status <> 'CFF';";
		System.out.println("CFF executada!");

		consulta.execute(query);
	}

	public static void numero_pedido() throws ClassNotFoundException, SQLException {

		inicializa();

		Long codpedido = null;
		String query = "SELECT codpedido from vendas.pedidos ORDER BY codpedido desc limit 1";

		ResultSet resultado = consulta.executeQuery(query);

		while (resultado.next()) {

			codpedido = resultado.getLong("codpedido");
			break;
		}
		System.out.println("Numero do Pedido: ");
		System.out.println(codpedido);
	}

	public static void altera_situacao_pedido() throws ClassNotFoundException, SQLException {

		inicializa();

		String query = "update vendas.pedidos set situacao = 'P' where codpedido in  (select max (codpedido) from vendas.pedidos)";

		consulta.execute(query);
	}

//	public static String buscaControlePedido() throws ClassNotFoundException, SQLException {
//
//		inicializa();
//
//		String codigo = null;
//		String query = "SELECT codigo FROM vendas.pedidos INNER JOIN pedcontrole ON pedidos.codpedido = pedcontrole.codpedido ORDER BY pedidos.codpedido DESC LIMIT 1";
//
//		ResultSet resultado = consulta.executeQuery(query);
//
//		while (resultado.next()) {
//
//			codigo = resultado.getString("codigo");
//			System.out.println(codigo);
//			break;
//		}
//		return codigo;
//	}

	public static String buscaControlePedido() throws ClassNotFoundException, SQLException {

		inicializa();

		String codigo = null;
		String query = "select * from pedcontrole  where filial = " + filial + " ORDER BY codigo DESC LIMIT 1;";

		ResultSet resultado = consulta.executeQuery(query);

		while (resultado.next()) {

			codigo = resultado.getString("codigo");
			System.out.println(codigo);
			break;
		}
		return codigo;
	}

	// para o tipodoc informar 'NFE' para pedidos com clientes ou 'NFC' para pedidos
	// de consumidor final
	public static void retornaCaixa(String tipoDoc) throws ClassNotFoundException, SQLException {
		inicializa();

		Long codpedido = null;
		String query = "SELECT codpedido from vendas.pedidos ORDER BY codpedido desc limit 1";

		ResultSet resultado = consulta.executeQuery(query);

		while (resultado.next()) {

			codpedido = resultado.getLong("codpedido");
			break;
		}
		String queryRetornaCaixa = "select caixa.retornar_pre_venda(34, 'PED', '" + tipoDoc + "' ," + codpedido
				+ " , 'caixa');";
		consulta.execute(queryRetornaCaixa);
	}

	public static String codigoOperacaoFiscal() throws ClassNotFoundException, SQLException {

		inicializa();

		String codoperacao = null;
		String query = "select codoperacao from vendas.pedidos ORDER BY codpedido desc limit 1;";

		ResultSet resultado = consulta.executeQuery(query);

		while (resultado.next()) {

			codoperacao = resultado.getString("codoperacao");
			break;
		}
		return codoperacao;
	}

	public static String itemMedida() throws ClassNotFoundException, SQLException {

		inicializa();

		String unidade = null;
		String query = "select unidade from vendas.pedidos_itens ORDER BY codpedido desc limit 1;";

		ResultSet resultado = consulta.executeQuery(query);

		while (resultado.next()) {

			unidade = resultado.getString("unidade");
			break;
		}
		return unidade;
	}

	// ======================================================================================

	public static String observacao() throws ClassNotFoundException, SQLException {

		inicializa();

		String texto = null;
		String query = "select observacao from vendas.pedidos ORDER BY codpedido desc limit 1;";

		ResultSet resultado = consulta.executeQuery(query);

		while (resultado.next()) {

			texto = resultado.getString("observacao");
			break;
		}
		return texto;
	}

	public static String condicaoPagamento() throws ClassNotFoundException, SQLException {

		inicializa();

		String pagamento = null;
		String query = "select condicao from vendas.pedidos ORDER BY codpedido desc limit 1;";

		ResultSet resultado = consulta.executeQuery(query);

		while (resultado.next()) {

			pagamento = resultado.getString("condicao");
			break;
		}
		return pagamento;
	}

	public static String desconto() throws ClassNotFoundException, SQLException {

		inicializa();

		String desconto = null;
		String query = "select tot_desconto from vendas.pedidos ORDER BY codpedido desc limit 1;";

		ResultSet resultado = consulta.executeQuery(query);

		while (resultado.next()) {

			desconto = resultado.getString("tot_desconto");
			break;
		}
		return desconto;
	}

	public static String acrescimo() throws ClassNotFoundException, SQLException {

		inicializa();

		String acrescimo = null;
		String query = "select tot_acrescimo from vendas.pedidos ORDER BY codpedido desc limit 1;";

		ResultSet resultado = consulta.executeQuery(query);

		while (resultado.next()) {

			acrescimo = resultado.getString("tot_acrescimo");
			break;
		}
		return acrescimo;
	}

	public static String totalBruto() throws ClassNotFoundException, SQLException {

		inicializa();

		String bruto = null;
		String query = "select total from vendas.pedidos ORDER BY codpedido desc limit 1;";

		ResultSet resultado = consulta.executeQuery(query);

		while (resultado.next()) {

			bruto = resultado.getString("total");
			break;
		}
		return bruto;
	}

	public static String totalLiquido() throws ClassNotFoundException, SQLException {

		inicializa();

		String liquido = null;
		String query = "select total_liquido from vendas.pedidos ORDER BY codpedido desc limit 1;";

		ResultSet resultado = consulta.executeQuery(query);

		while (resultado.next()) {

			liquido = resultado.getString("total_liquido");
			break;
		}
		return liquido;
	}

	public static String codigoCompra() throws ClassNotFoundException, SQLException {

		inicializa();

		String codigo = null;
		String query = "select ordem_compra from vendas.pedidos ORDER BY codpedido desc limit 1;";

		ResultSet resultado = consulta.executeQuery(query);

		while (resultado.next()) {

			codigo = resultado.getString("ordem_compra");
			break;
		}
		return codigo;
	}

	public static String sucata() throws ClassNotFoundException, SQLException {

		inicializa();

		String sucata = null;
		String query = "select tot_desconto_sucata from vendas.pedidos ORDER BY codpedido desc limit 1;";

		ResultSet resultado = consulta.executeQuery(query);

		while (resultado.next()) {

			sucata = resultado.getString("tot_desconto_sucata");
			break;
		}
		return sucata;
	}

	public static String entrega() throws ClassNotFoundException, SQLException {

		inicializa();

		String tpvenda = null;
		String query = "select tpvenda from vendas.pedidos ORDER BY codpedido desc limit 1;";

		ResultSet resultado = consulta.executeQuery(query);

		while (resultado.next()) {

			tpvenda = resultado.getString("tpvenda");
			break;
		}
		return tpvenda;
	}

	public static String quantidadeItem() throws ClassNotFoundException, SQLException {

		inicializa();

		String volume = null;
		String query = "select volume from vendas.pedidos ORDER BY codpedido desc limit 1;";

		ResultSet resultado = consulta.executeQuery(query);

		while (resultado.next()) {

			volume = resultado.getString("volume");
			break;
		}
		return volume;
	}

	public static String TotalFrete() throws ClassNotFoundException, SQLException {

		inicializa();

		String frete = null;
		String query = "select tot_frete from vendas.pedidos ORDER BY codpedido desc limit 1;";

		ResultSet resultado = consulta.executeQuery(query);

		while (resultado.next()) {

			frete = resultado.getString("tot_frete");
			break;
		}
		return frete;
	}

	// =============================== Transporte ===============================

	public static String tpFrete() throws ClassNotFoundException, SQLException {

		inicializa();

		String tpfrete = null;
		String query = "select tpfrete from vendas.pedidos ORDER BY codpedido desc limit 1;";

		ResultSet resultado = consulta.executeQuery(query);

		while (resultado.next()) {

			tpfrete = resultado.getString("tpfrete");
			System.out.println(tpfrete);
			break;
		}
		return tpfrete;
	}

	public static String pesoBruto() throws ClassNotFoundException, SQLException {

		inicializa();

		String pesoBruto = null;
		String query = "select peso_bruto from vendas.pedidos ORDER BY codpedido desc limit 1;";

		ResultSet resultado = consulta.executeQuery(query);

		while (resultado.next()) {

			pesoBruto = resultado.getString("peso_bruto");
			System.out.println(pesoBruto);
			break;
		}
		return pesoBruto;
	}

	public static String pesoLiquido() throws ClassNotFoundException, SQLException {

		inicializa();

		String pesoLiquido = null;
		String query = "select peso_liquido from vendas.pedidos ORDER BY codpedido desc limit 1;";

		ResultSet resultado = consulta.executeQuery(query);

		while (resultado.next()) {

			pesoLiquido = resultado.getString("peso_liquido");
			System.out.println(pesoLiquido);
			break;
		}
		return pesoLiquido;
	}

	public static String especie() throws ClassNotFoundException, SQLException {

		inicializa();

		String especie = null;
		String query = "select especie from vendas.pedidos ORDER BY codpedido desc limit 1;";

		ResultSet resultado = consulta.executeQuery(query);

		while (resultado.next()) {

			especie = resultado.getString("especie");
			System.out.println(especie);
			break;
		}
		return especie;
	}

	public static String marca() throws ClassNotFoundException, SQLException {

		inicializa();

		String marca = null;
		String query = "select marca from vendas.pedidos ORDER BY codpedido desc limit 1;";

		ResultSet resultado = consulta.executeQuery(query);

		while (resultado.next()) {

			marca = resultado.getString("marca");
			System.out.println(marca);
			break;
		}
		return marca;
	}
}
