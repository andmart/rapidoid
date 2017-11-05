package org.rapidoid.http.customize.defaults;

/*
 * #%L
 * rapidoid-http-fast
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

import org.rapidoid.RapidoidThing;
import org.rapidoid.annotation.Authors;
import org.rapidoid.annotation.Since;
import org.rapidoid.http.Req;
import org.rapidoid.http.customize.Customization;

import java.util.Map;
import org.rapidoid.http.customize.XmlRequestBodyParser;

@Authors("Dan Cytermann")
@Since("5.5.0")
public class DefaultXmlRequestBodyParser extends RapidoidThing implements XmlRequestBodyParser {

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, ?> parseXmlBody(Req req, byte[] body) throws Exception {
		return Customization.of(req).jacksonXml().readValue(body, Map.class);
	}

}