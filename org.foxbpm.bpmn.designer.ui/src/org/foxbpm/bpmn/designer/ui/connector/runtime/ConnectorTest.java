package org.foxbpm.bpmn.designer.ui.connector.runtime;

import java.io.File;
import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.foxbpm.bpmn.designer.base.utils.ZipUtils;

public class ConnectorTest {

	public static void main(String[] args) {
//		ClientResource client = new ClientResource("http://127.0.0.1:8080/foxbpm-webapps-rest/service/connectors");
//		client.setChallengeResponse(ChallengeScheme.HTTP_BASIC,"111", "111");
//		Representation result = client.get();
//		try {
//			File file = new File("d:\\testdownload.zip");
//			if(file.exists()){
//				file.delete();
//			}
//			FileOutputStream fileOutputStream = new FileOutputStream(file);
//			result.write(fileOutputStream);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		Authenticator.setDefault(new Authenticator() { protected PasswordAuthentication getPasswordAuthentication() { return new PasswordAuthentication("111", "111".toCharArray()); } });  
		URL url = null;
		File file = null;
		try {
//			url = new URL("http://172.16.40.89:8080/foxbpm-webapps-rest/service/connectors");
			url = new URL("http://172.16.40.89:8010/foxbpm/service/connectors");
			file = File.createTempFile(System.currentTimeMillis()+"test", ".zip");
			FileUtils.copyURLToFile(url, file);
			ZipUtils.unZip(file.getPath(), "D:/connector/test");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
