package utils;

import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class Util {

	public final static class WebClient {

		private String server;

		private final Client client;

		private Map<String, ? extends Object> params;

		private WebTarget target;

		private WebClient() {

			this.client = ClientBuilder.newClient();
		}

		private static final WebClient INSTANCE = new WebClient();

		public static final WebClient getWebClientInstance() {

			return getWebClientInstance("http://localhost");
		}

		public static final WebClient getWebClientInstance(String server) {

			INSTANCE.server = server;
			return INSTANCE;
		}

		public WebClient setQuery(Map<String, ? extends Object> params) {

			INSTANCE.params = params;
			return INSTANCE;
		}

		public String sendPostRequest(String endPoint, MultivaluedMap<String, String> requestBody) {

			target = this.client.target(server).path(endPoint);

			if (INSTANCE.params != null)
				INSTANCE.params.forEach((key, value) -> {
					target = target.queryParam(key, value);
				});

			System.out.println(target.getUri());

			Invocation.Builder requestBuilder = target.request(MediaType.APPLICATION_FORM_URLENCODED);

			Response response = requestBuilder.post(Entity.form(requestBody));

			return response.readEntity(String.class);
		}
	}
}
