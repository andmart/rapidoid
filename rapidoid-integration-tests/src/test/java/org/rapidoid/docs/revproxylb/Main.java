package org.rapidoid.docs.revproxylb;

/*
 * #%L
 * rapidoid-integration-tests
 * %%
 * Copyright (C) 2014 - 2017 Nikolche Mihajlovski and contributors
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.rapidoid.http.Req;
import org.rapidoid.reverseproxy.LoadBalancer;
import org.rapidoid.reverseproxy.ProxyUpstream;
import org.rapidoid.reverseproxy.Reverse;
import org.rapidoid.setup.App;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		App.bootstrap(args);

		LoadBalancer lb = (Req req, List<ProxyUpstream> candidates) -> {
			int index = 0; // FIXME implement load balancing strategy
			return candidates.get(index);
		};

		Reverse.proxy("/")
			.to("http://upstream1:8080", "http://upstream2:8080")
			.loadBalancer(lb)
			.add();
	}

}
