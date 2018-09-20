package com.kun.utilwork.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * MD5 Hash 方法
 */
public class MD5Hash
{

    public static String md5(String data)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(data.getBytes());
            StringBuffer buf = new StringBuffer();
            byte[] bits = md.digest();
            for (int i = 0; i < bits.length; i++)
            {
                int a = bits[i];
                if (a < 0)
                    a += 256;
                if (a < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(a));
            }
            return buf.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            return UUID.randomUUID().toString();
        }

    }

    public static void main(String[] args)
    {
        System.out.println(md5("123"));
    }
}
