/**
 * Copyright © 2016-2025 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data.device.credentials.lwm2m;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

@Getter
@Setter
public class PSKClientCredential extends AbstractLwM2MClientSecurityCredential {
    private String identity;

    @Override
    public LwM2MSecurityMode getSecurityConfigClientMode() {
        return LwM2MSecurityMode.PSK;
    }

    @Override
    public byte[] getDecoded() throws IllegalArgumentException, DecoderException {
        if (securityInBytes == null) {
                securityInBytes = Hex.decodeHex(key.toLowerCase().toCharArray());
        }
        return securityInBytes;
    }
}