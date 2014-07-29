package org.foxbpm.bpmn.designer.base.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.eclipse.jface.dialogs.MessageDialog;

public class FileUtil {
	/**
	 * Java文件操作 获取文件扩展名
	 * 
	 * @param filename
	 * @return
	 */
	public static String getExtensionName(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length() - 1))) {
				return filename.substring(dot + 1);
			}
		}
		return filename;
	}

	/**
	 * 返回文件名
	 * 
	 * @param path
	 * @return
	 */
	public static String getFileName(String path) {
		if (path == null)
			return "";
		File file = new File(path);
		return file.getName();
	}
	
	/**
	 * 复制文件
	 * @param sourceFile 源文件
	 * @param targetFile 目标文件
	 * @throws IOException
	 */
	public static void copyFile(File sourceFile, File targetFile) throws IOException {
		BufferedInputStream inBuff = null;
		BufferedOutputStream outBuff = null;
		try {
			// 新建文件输入流并对它进行缓冲
			inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

			// 新建文件输出流并对它进行缓冲
			outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

			// 缓冲数组
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = inBuff.read(b)) != -1) {
				outBuff.write(b, 0, len);
			}
			// 刷新此缓冲的输出流
			outBuff.flush();
		} finally {
			// 关闭流
			if (inBuff != null)
				inBuff.close();
			if (outBuff != null)
				outBuff.close();
		}
	}

	/**
	 * 读取文件流
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static byte[] readFile(String filename) throws IOException {

		File file = new File(filename);
		if (filename == null || filename.equals("")) {
			throw new NullPointerException("无效的文件路径");
		}
		long len = file.length();
		byte[] bytes = new byte[(int) len];

		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
		int r = bufferedInputStream.read(bytes);
		if (r != len)
			throw new IOException("读取文件不正确");
		bufferedInputStream.close();

		return bytes;

	}

	/**
	 * 文件读成字符串(UTF8编码)
	 * 
	 * @param file
	 * @return
	 */
	public static String readFile2StringUTF8(String filePath) {
		File file = new File(filePath);
		Long filelength = file.length();
		byte[] filecontent = new byte[filelength.intValue()];
		try {
			FileInputStream in = new FileInputStream(file);
			in.read(filecontent);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			return new String(filecontent, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void saveFileText(String filetext, String filePath) {
		try {
			FileWriter fw = new FileWriter(filePath);
			fw.write(filetext, 0, filetext.length());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void zipFile(String filePath,  List<Map<String, Object>> files, String format) {
		try {
			ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(filePath)));
			zos.setEncoding(format);
			
			for (Map<String, Object> file : files) {
				ZipEntry entry = new ZipEntry(file.get("NAME").toString());
				entry.setSize(((byte[])file.get("BYTES")).length);
				zos.putNextEntry(entry);
				zos.write((byte[])file.get("BYTES"));
				zos.closeEntry();
			}
			
			zos.close();
		} catch (FileNotFoundException e) {
			MessageDialog.openInformation(null, "提示", "目录未找到或者正在被其他程序使用！");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**

     *将对象序列化到磁盘文件中

     *@paramo

     *@throwsException

     */

    public static void writeObject(Object o, String path) throws Exception{

	       File f=new File(path);
	
	       if(f.exists()){
	
	           f.delete();
	
	       }
	
	       FileOutputStream os=new FileOutputStream(f);
	
	       //ObjectOutputStream 核心类
	
	       ObjectOutputStream oos=new ObjectOutputStream(os);
	
	       oos.writeObject(o);
	
	       oos.close();
	
	       os.close();

    }
    
    /**

     *反序列化,将磁盘文件转化为对象

     *@paramf

     *@return

     *@throwsException

     */

    public static Object readObject(File f) throws Exception{

    	Object obj = new Object();
        InputStream is=new FileInputStream(f);

        //ObjectOutputStream 核心类

        ObjectInputStream ois=new ObjectInputStream(is);
        obj = ois.readObject();
        
        ois.close();
        
        return obj;

    }
}
