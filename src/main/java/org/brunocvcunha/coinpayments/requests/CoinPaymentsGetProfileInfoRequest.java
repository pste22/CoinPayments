/**
 * Copyright (C) 2018 Bruno Candido Volpato da Cunha (brunocvcunha@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.brunocvcunha.coinpayments.requests;

import org.brunocvcunha.coinpayments.model.GetConversionInfoResponse;
import org.brunocvcunha.coinpayments.model.GetProfileInfoResponse;
import org.brunocvcunha.coinpayments.model.ResponseWrapper;
import org.brunocvcunha.coinpayments.requests.base.CoinPaymentsPostRequest;

import com.fasterxml.jackson.core.type.TypeReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CoinPaymentsGetProfileInfoRequest extends CoinPaymentsPostRequest<ResponseWrapper<GetProfileInfoResponse>> {
	
	private String pbntag;
	
	@Override
	public String getUrl() {
		return "";
	}
	
    @Override
    public String getPayload() {
        return "cmd=get_pbn_info&pbntag=" + pbntag;
    }

	@Override
	public ResponseWrapper<GetProfileInfoResponse> parseResult(int resultCode, String content) {
        ResponseWrapper<GetProfileInfoResponse> wrapper = parseJson(content, new TypeReference<ResponseWrapper<GetProfileInfoResponse>>() {});
        return wrapper;
	}

}
