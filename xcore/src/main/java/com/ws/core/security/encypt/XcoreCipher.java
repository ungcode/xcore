package com.ws.core.security.encypt;

import java.util.Base64;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import com.ws.core.util.DBProperties;


public class XcoreCipher {


	private static final String ALGORITHM = DBProperties.C_ALGORITHM;

	private static Cipher ecipher;
  
  private static Cipher dcipher;
  
	private String sharedKey = DBProperties.C_KEY;
  
  private static SecretKey key;
  
	public XcoreCipher() throws Exception
	{

      key = KeyGenerator.getInstance(ALGORITHM).generateKey();
      ecipher = Cipher.getInstance(ALGORITHM);
      dcipher = Cipher.getInstance(ALGORITHM);
      ecipher.init(1, key);
      dcipher.init(2, key);

  }
  
	public XcoreCipher(Properties property) throws Exception
	{

      DESKeySpec dks = new DESKeySpec(this.sharedKey.getBytes());
      SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
      key = skf.generateSecret(dks);
      ecipher = Cipher.getInstance(ALGORITHM);
      dcipher = Cipher.getInstance(ALGORITHM);
      ecipher.init(1, key);
      dcipher.init(2, key);

  }
  
	public Cipher getEncypher() throws Exception
	{

      DESKeySpec dks = new DESKeySpec(this.sharedKey.getBytes());
      SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
      key = skf.generateSecret(dks);
      ecipher = Cipher.getInstance(ALGORITHM);
      ecipher.init(1, key);

    return ecipher;
  }
  
	public Cipher getDecypher() throws Exception
	{
      DESKeySpec dks = new DESKeySpec(this.sharedKey.getBytes());
      SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
      key = skf.generateSecret(dks);
      dcipher = Cipher.getInstance(ALGORITHM);
      dcipher.init(2, key);
    return dcipher;
  }
  
	public String encrypt(String str) throws Exception
	{
      byte[] utf8 = str.getBytes("UTF8");
      byte[] enc = getEncypher().doFinal(utf8);
			enc = Base64.getEncoder().encode(enc);
      return new String(enc);
  }
  
	public String decrypt(String str) throws Exception
	{

			byte[] dec = Base64.getDecoder().decode(str.getBytes());
      byte[] utf8 = getDecypher().doFinal(dec);
      return new String(utf8, "UTF8");
  }

}
