package cn.io.study02;
/**
 * 1,图片读取到字节数组
 * 2，字节数字到文件
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileToInterface {
	public void collectFile(String srcPath,String  destPath) {
		File  src=new File(srcPath);
		File dest=new File(destPath);
		InputStream is=null;
		InputStream byteis=null;
		OutputStream os=null;
		ByteArrayOutputStream byteos=null;
		try {
			is=new FileInputStream(src);
			os=new FileOutputStream(dest,true);
			byteos=new ByteArrayOutputStream();
			byte[] flush=new byte[1024];
			int len=-1;
	        while((len=is.read(flush))!=-1) {
	        	byteos.write(flush,0,len);
	        	byteos.writeTo(os);
	         }
	      	byteos.flush();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(null!=is) {
				is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(null!=os) {
				is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 1、图片读取到字节数组
	 * 1)、图片到程序  FileInputStream
	 * 2)、程序到字节数组	ByteArrayOutputStream
	 */
	public static byte[] fileToByteArray(String filePath) {
		File src=new File(filePath);
		ByteArrayOutputStream byteArr=null;
		InputStream is=null;
		try {
			is=new FileInputStream(src);
			byteArr=new ByteArrayOutputStream();
			byte[] flush=new byte[1024];
		    int len=-1;
			while((len=is.read(flush))!=-1) {
				byteArr.write(flush);
			  }
			byteArr.flush();
			return byteArr.toByteArray();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(null!=is) {
				is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
		
	}	
	/**
	 * 2、字节数组写出到图片
	 * 1)、字节数组到程序 ByteArrayInputStream
	 * 2)、程序到文件 FileOutputStream
	 */
	public static void byteArrayToFile(byte[] src,String filePath) {
		File dest=new File(filePath);
		OutputStream os=null;
		InputStream is=null;
		
		try {
			os=new FileOutputStream(dest,true);
			is=new ByteArrayInputStream(src,0,src.length);
			byte[] flush=new byte[1024];
			int len=-1;
			while((len=is.read(flush))!=-1) {
				os.write(flush,0,len);
			}
			os.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			if(null!=os) {
			is.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		FileToInterface fi=new FileToInterface();
		fi.collectFile("E:\\workspace-java\\IO流技术\\捕获2.png", "E:\\\\workspace-java\\\\IO流技术\\\\des.png");
		
		/*byte[] res=fileToByteArray("E:\\workspace-java\\IO流技术\\捕获2.png");
		System.out.println(res.length);
		byteArrayToFile(res,"E:\\\\workspace-java\\\\IO流技术\\\\des1.png");*/
	}

}
