<%@ page autoFlush="false" contentType="text/html;charset=utf-8" language="java" %>
<%@ page import="java.io.*" %>
<%@ page import="java.awt.Image" %>
<%@ page import="java.awt.image.*" %>
<%@ page import="com.sun.image.codec.jpeg.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.jspsmart.upload.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.FileOutputStream" %>
<%@ page import="java.awt.*" %>
<%
	long file_size_max=4194304;
	String ext="";
	String url="upload_image/";
	SmartUpload mySmartUpload =new SmartUpload();
	
	//初始化
	mySmartUpload.initialize(pageContext);
	
	//只允许上载此类文件
	try {
		mySmartUpload.setAllowedFilesList("jpg,gif,png,JPG,GIF,PNG");
		//上载文件 
		mySmartUpload.upload();
	} catch (Exception e){%>
		<script>
		alert("只允许上传jpg,gif和png类型图片文件");
		window.location = "<%=request.getHeader("referer")%>";
		</script>
	<%}
	try{ 
		com.jspsmart.upload.File myFile = mySmartUpload.getFiles().getFile(0);
		if (myFile.isMissing()){%>
			<script>
			alert("请先选择要上传的文件");
			window.location='<%=request.getHeader("referer")%>';
			</script>
		<%}
		else{
			ext= myFile.getFileExt();
			int file_size=myFile.getSize();
			String saveurl="";//保存路径
			
			if(file_size<file_size_max){
				//更改文件名为当前上传时间的毫秒数值
				Calendar calendar = Calendar.getInstance();
				String filename = String.valueOf(calendar.getTimeInMillis()); 
				saveurl=request.getSession().getServletContext().getRealPath("/")+url;
				saveurl+=filename+"."+ext;
				myFile.saveAs(saveurl,mySmartUpload.SAVE_PHYSICAL);
				//-----------------------上传完成，开始生成缩略图------------------------- 
				java.io.File file = new java.io.File(saveurl); //读入刚才上传的文件
				String newurl=request.getSession().getServletContext().getRealPath("/")+url+filename+"_min."+ext; //新的缩略图保存地址
				Image src = javax.imageio.ImageIO.read(file); //构造Image对象
				float tagsize=150;
				int old_w=src.getWidth(null); //得到源图长宽
				int old_h=src.getHeight(null);
				int new_w=0;
				int new_h=0;
				int tempsize;
				float tempdouble;
				if(old_w>old_h){
					tempdouble=old_w/tagsize;
				}else{
					tempdouble=old_h/tagsize;
				}
				new_w=Math.round(old_w/tempdouble);
				new_h=Math.round(old_h/tempdouble);//计算新图长宽
				
				BufferedImage image = new BufferedImage(new_w,new_h,BufferedImage.TYPE_INT_RGB);//创建一个BufferedImage来作为图像操作容器 
				Graphics g = image.getGraphics(); //创建一个绘图环境来进行绘制图象 
				g.drawImage(src,0,0,new_w,new_h,null); //将原图像数据流载入这个BufferedImage 
				g.setFont(new Font("Times New Roman",Font.PLAIN,24)); //设定文本字体 
				
				//水印
				String rand = ""; 
				g.setColor(Color.red); //设定文本颜色 
				g.drawString(rand,new_w-200,new_h-10); //向BufferedImage写入文本字符 
				g.dispose(); //使更改生效
			
				FileOutputStream newimage=new FileOutputStream(newurl); //输出到文件流
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage); 
				encoder.encode(image); //近JPEG编码
				newimage.close(); 
				
				//转向servlet处理
				session.setAttribute("src", url+filename+"_min."+ext);
				String level = mySmartUpload.getRequest().getParameter("level");
				String description = mySmartUpload.getRequest().getParameter("description");
				String title = mySmartUpload.getRequest().getParameter("title");
				String version = mySmartUpload.getRequest().getParameter("version");
				String software = mySmartUpload.getRequest().getParameter("software");
				String graph_address = url+filename+"."+ext;
				%><jsp:forward page="upload">
				<jsp:param value="<%=level %>" name="level"/>
				<jsp:param value="<%=description %>" name="description"/>
				<jsp:param value="<%=title %>" name="title"/>
				<jsp:param value="<%=version %>" name="version"/>
				<jsp:param value="<%=software %>" name="software"/>
				<jsp:param value="<%=graph_address %>" name="graph_address"/>
			</jsp:forward><%
			}
			else{%>
				<script>
					alert('上传文件大小不能超过<%=(file_size_max/1024)%>K');
					window.location='<%=request.getHeader("referer")%>';
				</script>
			<%}
		}
	}catch (Exception e){
		out.println(e.toString());
	}
%>