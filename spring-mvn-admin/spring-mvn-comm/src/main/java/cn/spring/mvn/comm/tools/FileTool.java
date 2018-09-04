package cn.spring.mvn.comm.tools;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.xmlbeans.impl.common.IOUtil;

/**
 * @author LiuTao @date 2018年5月16日 下午3:39:14
 * @ClassName: FileTool 
 * @Description: TODO(文件操作工具类)
 */
public class FileTool {
	//
	private static final int  BUFFER_SIZE = 2 * 1024;
	
	/**
	 * @author LiuTao @date 2018年5月15日 下午9:11:23 
	 * @Title: webDownloadFile 
	 * @Description: TODO(web前端下载文件) 
	 * @param srcFile
	 * @param downloadFileName
	 * @param response
	 * @throws Exception 
	 */
	public static void webDownloadFile(File srcFile, String downloadFileName, String postFixStr, HttpServletResponse response) throws Exception {
		try {
			FileInputStream fileInputStream = new FileInputStream(srcFile);
			response.setContentType("application/octet-stream;charset=GBK");
			String fileName = new String(URLEncoder.encode((downloadFileName + postFixStr), "UTF-8").getBytes("GBK"), "ISO-8859-1");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
			IOUtil.copyCompletely(fileInputStream, bufferedOutputStream);
			bufferedOutputStream.flush();
			fileInputStream.close();
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * @author LiuTao @date 2018年5月14日 上午10:22:55 
	 * @Title: readFileByBytes 
	 * @Description: TODO(以字节为单位读取文件,常用于读二进制文件,如图片、声音、影像等文件) 
	 * @param fileName
	 */
    public static void readFileByBytes(String fileName) {
        File file = new File(fileName);
        InputStream in = null;
        try {
            System.out.println("以字节为单位读取文件内容,一次读一个字节:");
            // 一次读一个字节
            in = new FileInputStream(file);
            int tempbyte;
            while ((tempbyte = in.read()) != -1) {
                System.out.write(tempbyte);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        try {
            System.out.println("以字节为单位读取文件内容,一次读多个字节:");
            // 一次读多个字节
            byte[] tempbytes = new byte[100];
            int byteread = 0;
            in = new FileInputStream(fileName);
//            ReadFromFile.showAvailableBytes(in);
            // 读入多个字节到字节数组中,byteread为一次读入的字节数
            while ((byteread = in.read(tempbytes)) != -1) {
                System.out.write(tempbytes, 0, byteread);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 以字符为单位读取文件,常用于读文本,数字等类型的文件
     */
    public static void readFileByChars(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        try {
            System.out.println("以字符为单位读取文件内容,一次读一个字节:");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下,\r\n这两个字符在一起时,表示一个换行.
                // 但如果这两个字符分开显示时,会换两次行.
                // 因此,屏蔽掉\r,或者屏蔽\n.否则,将会多出很多空行.
                if (((char) tempchar) != '\r') {
                    System.out.print((char) tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("以字符为单位读取文件内容,一次读多个字节:");
            // 一次读多个字符
            char[] tempchars = new char[30];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(fileName));
            // 读入多个字符到字符数组中,charread为一次读取字符数
            while ((charread = reader.read(tempchars)) != -1) {
                // 同样屏蔽掉\r不显示
                if ((charread == tempchars.length)
                        && (tempchars[tempchars.length - 1] != '\r')) {
                    System.out.print(tempchars);
                } else {
                    for (int i = 0; i < charread; i++) {
                        if (tempchars[i] == '\r') {
                            continue;
                        } else {
                            System.out.print(tempchars[i]);
                        }
                    }
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * @author LiuTao @date 2018年5月14日 上午10:27:01 
     * @Title: readFileByLines 
     * @Description: TODO(以行为单位读取文件,常用于读面向行的格式化文件) 
     * @param fileName
     */
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容,一次读一整行:");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行,直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 随机读取文件内容
     */
    public static void readFileByRandomAccess(String fileName) {
        RandomAccessFile randomFile = null;
        try {
            System.out.println("随机读取一段文件内容:");
            // 打开一个随机访问文件流,按只读方式
            randomFile = new RandomAccessFile(fileName, "r");
            // 文件长度,字节数
            long fileLength = randomFile.length();
            // 读文件的起始位置
            int beginIndex = (fileLength > 4) ? 4 : 0;
            // 将读文件的开始位置移到beginIndex位置.
            randomFile.seek(beginIndex);
            byte[] bytes = new byte[10];
            int byteread = 0;
            // 一次读10个字节,如果文件内容不足10个字节,则读剩下的字节.
            // 将一次读取的字节数赋给byteread
            while ((byteread = randomFile.read(bytes)) != -1) {
                System.out.write(bytes, 0, byteread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomFile != null) {
                try {
                    randomFile.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 显示输入流中还剩的字节数
     */
    public static void showAvailableBytes(InputStream in) {
        try {
            System.out.println("当前字节输入流中的字节数为:" + in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	
	/**
	 * @author LiuTao @date 2018年5月14日 上午9:53:03 
	 * @Title: fileDirToZip 
	 * @Description: TODO(压缩成ZIP 方法) 
	 * @param srcDir 压缩文件夹路径  源 
	 * @param rstZipFileDir    压缩文件输出流
	 * @param rstZipFileNme    压缩文件输出流
	 * @param KeepDirStructure  是否保留原来的目录结构,true:保留目录结构; 
	 * 							false:所有文件跑到压缩包根目录下(注意:不保留目录结构可能会出现同名文件,会压缩失败)
	 * @throws Exception 压缩失败会抛出运行时异常
	 */
	public static void fileDirToZip(String srcDir, String rstZipFileDir, String rstZipFileNme, boolean KeepDirStructure) throws Exception{
		File fileDir = new File(rstZipFileDir);
		if(!fileDir.exists()){
			fileDir.mkdirs();
		}
		File retZipFile = new File(rstZipFileDir.concat(File.separator).concat(rstZipFileNme));
		FileOutputStream out = new FileOutputStream(retZipFile);
		ZipOutputStream zos = null ;
		try {
			zos = new ZipOutputStream(out);
			File sourceFile = new File(srcDir);
			compress(sourceFile,zos,sourceFile.getName(),KeepDirStructure);
		} catch (Exception e) {
			throw new RuntimeException("zip error from FileToZip",e);
		}finally{
			if(zos != null){
				try {
					zos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	 * @author LiuTao @date 2018年5月14日 上午9:54:11 
	 * @Title: compress 
	 * @Description: TODO(递归压缩方法) 
	 * @param sourceFile 源文件
	 * @param zos		 zip输出流
	 * @param name		 压缩后的名称
	 * @param KeepDirStructure  是否保留原来的目录结构,true:保留目录结构; 
	 * 							false:所有文件跑到压缩包根目录下(注意:不保留目录结构可能会出现同名文件,会压缩失败)
	 * @throws Exception
	 */
	private static void compress(File sourceFile, ZipOutputStream zos, String name, boolean KeepDirStructure) throws Exception{
		byte[] buf = new byte[BUFFER_SIZE];
		if(sourceFile.isFile()){
			// 向zip输出流中添加一个zip实体,构造器中name为zip实体的文件的名字
			zos.putNextEntry(new ZipEntry(name));
			// copy文件到zip输出流中
			int len;
			FileInputStream in = new FileInputStream(sourceFile);
			while ((len = in.read(buf)) != -1){
				zos.write(buf, 0, len);
			}
			// Complete the entry
			zos.closeEntry();
			in.close();
		} else {
			File[] listFiles = sourceFile.listFiles();
			if(listFiles == null || listFiles.length == 0){
				// 需要保留原来的文件结构时,需要对空文件夹进行处理
				if(KeepDirStructure){
					// 空文件夹的处理
					zos.putNextEntry(new ZipEntry(name + "/"));
					// 没有文件,不需要文件的copy
					zos.closeEntry();
				}
				
			}else {
				for (File file : listFiles) {
					// 判断是否需要保留原来的文件结构
					if (KeepDirStructure) {
						// 注意:file.getName()前面需要带上父文件夹的名字加一斜杠,
						// 不然最后压缩包中就不能保留原来的文件结构,即:所有文件都跑到压缩包根目录下了
						compress(file, zos, name + "/" + file.getName(),KeepDirStructure);
					} else {
						compress(file, zos, file.getName(),KeepDirStructure);
					}
					
				}
			}
		}
	}
	
	/**
	 * @author LiuTao @date 2018年5月14日 上午9:54:38 
	 * @Title: unZipToFile 
	 * @Description: TODO(解压文件到指定目录,解压后的文件名和之前一致) 
	 * @param srcFilePathWithName 待解压的zip文件 
	 * @param dstFilePath 指定目录 
	 * @throws IOException
	 */
    @SuppressWarnings({"resource"})  
	public static void unZipToFile(String srcFilePathWithName, String dstFilePath) throws IOException{
		File srcFile = new File(srcFilePathWithName);
		ZipFile zipFile = new ZipFile(srcFile,Charset.forName("GBK"));//解决中文文件夹乱码  
        String name = zipFile.getName().substring(zipFile.getName().lastIndexOf('\\')+1, zipFile.getName().lastIndexOf('.'));  
        File pathFile = new File(dstFilePath+name);  //
        if (!pathFile.exists()) {  
            pathFile.mkdirs();  
        }  

        for (Enumeration<? extends java.util.zip.ZipEntry> entries = zipFile.entries(); entries.hasMoreElements();) {  
        	java.util.zip.ZipEntry entry = (java.util.zip.ZipEntry) entries.nextElement();  
            String zipEntryName = entry.getName();  
            InputStream in = zipFile.getInputStream(entry);  
            String outPath = (dstFilePath + name +"/"+ zipEntryName).replaceAll("\\*", "/");  
            // 判断路径是否存在,不存在则创建文件路径  
            File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));  
            if (!file.exists()) {  
                file.mkdirs();  
            }  
            // 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压  
            if (new File(outPath).isDirectory()) {  
                continue;  
            }  
            FileOutputStream out = new FileOutputStream(outPath);  
            byte[] buf1 = new byte[BUFFER_SIZE];  
            int len;  
            while ((len = in.read(buf1)) > 0) {  
                out.write(buf1, 0, len);  
            }  
            in.close();  
            out.close();  
        }  
        return;  
	}
    /**
     * @author LiuTao @date 2018年5月16日 下午3:52:27 
     * @Title: writeFileByLines 
     * @Description: TODO(Describe) 
     * @param file
     * @param lines
     * @throws Exception 
     */
    public void writeFileByLines(File file, String lines) throws Exception {
		if(!file.exists()){
			file.getPath();
			return;
		}
    	try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF-8");
			outputStreamWriter.write(lines);
			outputStreamWriter.close();
			fileOutputStream.close();
		} catch (Exception e) {
			throw e;
		}
	}
}
;