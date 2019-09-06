define(function (require, exports, module) {
    var aes = require('./AES')
    var md5 = require('./MD5')
    var rsa = require('./RSA')

/**
 * aes加密
 */
    function aesEncrypt(data, aeskey) {
        //十六位十六进制数作为秘钥
        var key = aes.enc.Utf8.parse(aeskey);
        //十六位十六进制数作为秘钥偏移量
        var iv = aes.enc.Utf8.parse("HNNX_IBANK123456");
        var srcs = aes.enc.Utf8.parse(data);
        var mode = aes.mode.CBC;
        var pad = aes.pad.Pkcs7
        var encrypted = aes.AES.encrypt(srcs, key, { iv: iv, mode: mode, padding: pad });
        var result = encrypted.ciphertext.toString(aes.enc.Base64);
        return result;
    }

    function aesDecrypt(data, aeskey) {
    	var iv = aes.enc.Utf8.parse("HNNX_IBANK123456");
        var text = aes.AES.decrypt(data, aes.enc.Utf8.parse(aeskey), {
            iv: iv,
            mode: aes.mode.CBC,
            padding: aes.pad.Pkcs7
        });
        var result = aes.enc.Utf8.stringify(text);
        return result;
        //return JSON.parse(result);
    }

    /**
     * md5加密
     */
    function md5Encrypt(data, aeskey) {
        return md5.md5(aeskey + data).toUpperCase();
    }

    /**
     * rsa加密
     */
    function rsaEncrypt(data) {
        var encrypt_rsa = new rsa.RSAKey();
        encrypt_rsa = rsa.KEYUTIL.getKey(getPublicKey());
        var encStr = encrypt_rsa.encrypt(data)
        encStr = rsa.hex2b64(encStr);
        return encStr;
    }

    /**
     * 三段式加密
     */
    function encrypt(data, aeskey) {
        if (typeof data != 'string') {
            data = JSON.stringify(data);
        }
        var rsaText = rsaEncrypt(aeskey);
        var aesText = aesEncrypt(data, aeskey);
        var md5Text = md5Encrypt(data, aeskey);
        var result = [md5Text, aesText, rsaText].join(String.fromCharCode(29));
        return result;
    }

    function getAesKey() {
        return uuid(16, 16);
    }

    function uuid(len, radix) {
        var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
        var uuid = [], i;
        radix = radix || chars.length;
        if (len) {
            // Compact form
            for (i = 0; i < len; i++) uuid[i] = chars[0 | Math.random() * radix];
        } else {
            // rfc4122, version 4 form
            var r;
            // rfc4122 requires these characters
            uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
            uuid[14] = '4';
            // Fill in random data.  At i==19 set the high bits of clock sequence as
            // per rfc4122, sec. 4.1.5
            for (i = 0; i < 36; i++) {
                if (!uuid[i]) {
                    r = 0 | Math.random() * 16;
                    uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
                }
            }
        }
        return uuid.join('');
    }

    function getPublicKey() {
        //return '-----BEGIN PUBLIC KEY-----'+wx.getStorageSync('PUBLIC_KEY')+'-----END PUBLIC KEY-----';
        return '-----BEGIN CERTIFICATE-----MIICWTCCAcKgAwIBAgIEUZ2xCDANBgkqhkiG9w0BAQUFADBxMQswCQYDVQQGEwJjbjERMA8GA1UECBMIc2hhbmdoYWkxETAPBgNVBAcTCHNoYW5naGFpMQ8wDQYDVQQKEwZ5aXRvbmcxDzANBgNVBAsTBnlpdG9uZzEaMBgGA1UEAxMRc2hhbmcgaGFpIHlpIHRvbmcwHhcNMTMwNTIzMDYwMjQ4WhcNMTMwODIxMDYwMjQ4WjBxMQswCQYDVQQGEwJjbjERMA8GA1UECBMIc2hhbmdoYWkxETAPBgNVBAcTCHNoYW5naGFpMQ8wDQYDVQQKEwZ5aXRvbmcxDzANBgNVBAsTBnlpdG9uZzEaMBgGA1UEAxMRc2hhbmcgaGFpIHlpIHRvbmcwgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGBAIZPpqXmS4F4yFErkXLkJZ6WtW5/ri4sql0rXchu6tBs0RnxjG150JTW3rV6pZjZwtqyDLb5MOiqPBuKddIfTD+hvBJRSDhGYMzCHR/yYgxqqaMvQhwHyvnC4ff+UfHVcuiHrzkLx3j9aOQGNPJ+OCIyLW+cg+bRm3ad8bZgDB0lAgMBAAEwDQYJKoZIhvcNAQEFBQADgYEAZZngqwiyADKnyhW5rwDImR5nL3TCOVOk+KBNn1hGeurT6Ff4IHZM4Ji7e/54oPeA7eiD47gI8ep+eqSVjo9aCoZRUQxopcuhy+BTNqPGLJgP0OnLxHhD7l7Gb1ZqZevKeVbtqeLLhPrlN9FF7aLAFpddAJU5DZkaWD4d1D+OYRo=-----END CERTIFICATE-----';
    }

    module.exports = {
        aesEncrypt: aesEncrypt,
        aesDecrypt: aesDecrypt,
        md5Encrypt: md5Encrypt,
        rsaEncrypt: rsaEncrypt,
        getAesKey: getAesKey,
        encrypt: encrypt
    };
});