/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.zater.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import tk.zater.Constant;

/**
 *
 * @author zater
 */
public class Download {

    public  void download(String url,String path) throws IOException {
        try {
            URL targeturl=new URL(url);
            
            HttpHost proxy = null;
            RequestConfig config = null;
            CredentialsProvider credsProvider = new BasicCredentialsProvider();
            if (Constant.openproxy) {
                credsProvider.setCredentials(
                        new AuthScope(Constant.ip, Constant.port),
                        new UsernamePasswordCredentials(Constant.proxyusername, Constant.proxypassword));
                proxy = new HttpHost(Constant.ip, Constant.port);
                config = RequestConfig.custom()
                        .setProxy(proxy)
                        .build();
            }

            CloseableHttpClient httpclient = HttpClients.custom().setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko").setDefaultCredentialsProvider(credsProvider).build();
            HttpHost target = new HttpHost(targeturl.getHost(), targeturl.getPort(), targeturl.getProtocol());
            HttpGet httpget = new HttpGet(url);
            if(Constant.openproxy){
                httpget.setConfig(config);
                
            }
            CloseableHttpResponse res = httpclient.execute(target, httpget);
            HttpEntity entity = res.getEntity();
            InputStream is = entity.getContent();

            File file = new File(path);
            file.getParentFile().mkdirs();
            System.out.println(file.getAbsolutePath()); 
            FileOutputStream fileout = new FileOutputStream(file);
            int cache=2048;
            byte[] buffer = new byte[cache];
            int ch = 0;
            while ((ch = is.read(buffer)) != -1) {
                fileout.write(buffer, 0, ch);
            }
            is.close();
            fileout.flush();
            fileout.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
}
