# Servlets
- Servlets are the Java programs that run on the Java-enabled web server or application server. They are used to handle the request obtained from the webserver, process the request, produce the response, then send a response back to the webserver. 

- Properties of Servlets are as follows:

1. Servlets work on the server-side.
2. Servlets are capable of handling complex requests obtained from the webserver.

- Execution of Servlets basically involves six basic steps: 

1. The clients send the request to the webserver.

2. The web server receives the request.

3. The web server passes the request to the corresponding servlet.

4. The servlet processes the request and generates the response in the form of output.

5. The servlet sends the response back to the webserver.

6. The web server sends the response back to the client and the client browser displays it on the screen.

- Considering a client-server model, when a client sends a request to the server it expects a html page as a response from server.

- So this html page can be a static page or a dynamic page. on a server, if the page is already made it is called static page, if it  is not then that page needs to be build such html pages are called dynamic pages.

- Example of a static page is like the client request for index.html page from server, the server has that html page so it reponse back with that page. 

![](https://github.com/codophilic/LearnWebDevInJAVA/blob/main/Images/1.jpg)

- Example of a dynamic page is like if the client request for an abc.html (add two numbers in the request) page which is not present on Calculation server. So server needs to build that page on run time. So such request goes to the helper application (Web containers). 

- This web container has mapping of servlets. Servlets are basically java files which processes the request from the client on internet and provides the response in format of html page or any formats.

- The web container are basically application/web server which can be Apache Tomcat,IBM WebSphere, GlassFish etc.

- So lets say we are using Tomcat container, so the request is asked for abc.html (add the two numbers provided in the request) page, so that request goes to the servlet. Now servlet is basically java files which has names of it and there can be multiple servlets having different functionality(Subtract,Add,Multiple,Divide).

- So the request is of addition and we need to call add servlet.So on the Tomcat server there is a file web.xml which is called Deployment Descriptor. So the web.xml calls the servlet and runs that on tomcat server , the output response is send back to the Calculation server.

- This web.xml maps every request to its respective servlets. There can be multiple request asking for same servlet so such scenario needs to be configured in web.xml. 

![](https://github.com/codophilic/LearnWebDevInJAVA/blob/main/Images/2.jpg)

## Create servlet

- Servlets are normal java class which extends HttpServlet class.

- This HttpServlet will provide all features like accepting/processing the request and sending response to the server.

- The response can be in any format like JSON,XML or html.

- No matter what is the reponse format , it goes back as an response object.

- In the latest version , instead of referring web.xml file we can have Annotations which provides the same mapping like xml files.

![](https://github.com/codophilic/LearnWebDevInJAVA/blob/main/Images/3.jpg)

- Used Eclipse Enteprise and web developer with Tomcat 9.

- We generate a new project named *DemoApplication* under Servlets folder. This new project consists of multiple folders.

- Looking into `src/main/webapp/WEB-INF` there is web.xml. Under *DemoApplication* there is `src/` folder which will contain all the java codes and logic for servlets.

- Created a simple *index.html* file. All html pages goes under `webapp` folder. Right click on page and use run on server.

- A servlet is a java file with a class name provided , having a custom package name provided. We can see there is a folder name `com/AddingNumbers` which is package and inside there we have *AddingServlet.java* file.

- We are using HTTP protocol which consists of 7 methods from which 5 methods are generally used (GET,POST,PUT,Delete,Option). The default method is used GET.

- To fetch data from server use GET, to submit the data to server use POST.

## HttpServletRequest/Response

- When a client sents a request to the server, the data, the browser information or ip all these details may be required to the server. So these details are formatted in form of an object.

- Similarly to send back the data/information the request are in format of objects. Data/information can be of any type.

- These object formatting is handle by Tomcat servers.

- HttpServletRequest/Response is an interface which is implemented by Tomcat.

- In the latest version `javax.servlet` package is been replaced by `jakarta.servlet`.(In Tomcat libraries , `servlet-api.jar` has defined these packages)

- To work with `jakarta` , go in **Properties->Java Build->Libraries->Add Library-> Server Runtime -> Apache Tomcat server** , Apply & Close.

- Any JARS working must be added in libraries ModulePath. This creates a References Libraries folder in eclipse.

## RequestDispatcher and sendRedirect

- In RequestDispatcher, we call one servlet(s1) from another servlet(s2). So, s1 request response object get passed to s2. S2 perform the operation and provides the response directly to the client page which has s1 url. These servlets are within same web application.

![](https://github.com/codophilic/LearnWebDevInJAVA/blob/main/Images/4.jpg)

- Suppose we are calling a servlet from one web application to another application (like in amazon the payment is re-directed to Paypal/BillDesk etc.) we use sendRedirect.

- So, S1 will re-directs the browser page of client with its response to S2 and S2 will perform operation and provide respose back to browser.

- So in sendRedirect thw browser gets two different responses.

![](https://github.com/codophilic/LearnWebDevInJAVA/blob/main/Images/5.jpg)

## Session

- Session simply means a particular interval of time. Session Tracking is a way to maintain state (data) of an user. It is also known as session management in servlet. Http protocol is a stateless so we need to maintain state using session tracking techniques.

- Each time user requests to the server, server treats the request as the new request. So we need to maintain the state of an user to recognize to particular user.

- HTTP is a “stateless” protocol, which means that each time a client requests a Web page, the client establishes a new connection with the Web server, and the server does not retain track of prior requests.

- The conversion of a user over a period of time is referred to as a session. In general, it refers to a certain period of time.

- The recording of the object in session is known as tracking.

- Session tracking is the process of remembering and documenting customer conversions over time. Session management is another name for it.

- The term “stateful web application” refers to a web application that is capable of remembering and recording client conversions over time.

- Suppose a servlets wants a data of another servlet , but it does not get called. The data should be passed in a concept called session.

- There are four techniques used in Session tracking:

1. Cookies

2. Hidden Form Field

3. URL Rewriting

4. HttpSession

### Cookies

- A cookie is a small piece of information generated from a specific websites which is stored in client computer.

- These cookies have multiple functions such has keeping track of user browsering activity which help to target ads. Example suppose in amazon you are searching for a laptop oof specific model, the same search context will also been shown on Flipkart,FB etc. 

- It also remebers login details of a client/user.

- Each cookie has its own unique ID which helps web developers to track how many user visit their site.

- When a user visit website for a first time, a cookie is created on their hard drive pc which keeps track of session during visit on their website.

- The cookie is stored in the user browser, the client (user’s browser) sends this cookie back to the server for all the subsequent requests until the cookie is valid. The Servlet container checks the request header for cookies and get the session information from the cookie and use the associated session from the server memory.

- The session remains active for the time specified in tag in web.xml. If tag in not set in web.xml then the session remains active for 30 minutes. Cookie remains active as long as the user’s browser is running, as soon as the browser is closed, the cookie and associated session info is destroyed. So when the user opens the browser again and sends request to web server, the new session is being created.

- If one runs the servlet link in incognito mode directly, cookies are not recognized and it is treated as a new user.

- 2 types of cookies in a session

1. Non-persistent cookie - It is valid for single session only. It is removed each time when user closes the browser.

2. Persistent cookie - It is valid for multiple session . It is not removed each time when user closes the browser. It is removed only if user logout or signout.

![](https://github.com/codophilic/LearnWebDevInJAVA/blob/main/Images/6.PNG)


## ServletConfig & ServletContext

- ServletConfig and ServletContext, both are objects created at the time of servlet initialization and used to provide some initial parameters or configuration information to the servlet. 

- But, the difference lies in the fact that information shared by ServletConfig is for a specific servlet, while information shared by ServletContext is available for all servlets in the web application.

### ServletConfig

- Let's say you are working with multiple DB's where different servlet will trigger its respected DB. So we here use ServletConfig where we define the configuration of DB for each servlet in web.xml

- ServletConfig object is one per Servlet component or class. It is accessible only within the configured servlet class.

- Can be used to gather init-param <init-param> values from the web.xml file to the Servlet component.	It can be accessed through getServletConfig() Method. Example:- ServletConfig cg = getServletConfig();



### ServletContext

- Let's say you are working with One DB where All servlet will trigger this particular DB only. So we here use ServletContext where we define the configuration of DB for in web.xml using servletcontext.

- The ServletContext object is one per web application.It is visible and accessible in all the servlet/JSP components of the web application, so it is also called the global memory of a web application.

- Can be used to gather context-param <context-param> values from the web.xml file to the Servlet component.It can be accessed through getServletContext() Method. Example:- ServletContext cs = getServletContext();


## Annotations

- the Servlet life cycle will be managed by the Servlet container that is under the Web/Application server. Whenever an HttpRequest comes from the client browser, the servlet container will map the request to the corresponding servlet based on the URL mappings provided in the deployment descriptor file – web.xml. 

- Java Servlets provides a number of annotations to allow users to declare servlets, filters, listeners in the `javax.servlet.annotation` package.

- Annotation represents the metadata. If you use annotation, deployment descriptor (web.xml file) is not required. But you should have tomcat7 as it will not run in the previous versions of tomcat. 

- `@WebServlet` annotation is used to map the servlet with the specified name.


**- To add JAR we need to configure those JARS in Properties>Java Build Path>Libraries. For Jakarta JARS we need to add server runtime library in the classpath**




# JSP ( Java Server Page )

- It stands for Java Server Pages.It is a server side technology. It is used for creating web application. It is used to create dynamic web content.

In this JSP tags are used to insert JAVA code into HTML pages. It is a Web based technology helps us to create dynamic and platform independent web pages. In this, Java code can be inserted in HTML/ XML pages or both.

- In a JSP file, between the HTML content , java codes are written between <% codes %> called delimeter.

- JSP provides reference variale of all objects like request and reponse object by itself named as **request** and **response** which are also called implicit Objects in JSP.

- A JSP page consists of HTML tags and JSP tags. The JSP pages are easier to maintain than Servlet because we can separate designing and development. It provides some additional features such as Expression Language, Custom Tags, etc.

## Why to use servlet if JSP is so easy?

- In the backend on servlet container (Tomcat) , the container run all the servlet files. It does not run JSP files, the JSP files are converted into servlets.

-  JSP page is translated into Servlet by the help of JSP translator. The JSP translator is a part of the web server which is responsible for translating the JSP page into Servlet. 

- After that, Servlet page is compiled by the compiler and gets converted into the class file. Moreover, all the processes that happen in Servlet are performed on JSP later like initialization, committing response to the browser and destroy.

- So, when we create a Add.jsp file, that JSP files will be converted into a servlet having class name present in JSP which **Add_jsp**. Now this servlet will extends `HttpServlet` and this servlet will provide all the objects/Service() method (doPost or doGet) required to work to the Add.JSP file (request,response,out etc. which are provided by the Tomcat to the servlet file). So the logic written in <% logic %> gets copied in the method of servlet.

- All the objects provided by the JSP are called implicit objects.

- <% %> tag are called as scriptlet.

![](https://github.com/codophilic/LearnWebDevInJAVA/blob/main/Images/7.jpg)

- Suppose you want to declare variable/method outside the method inside the class like instance variable, we can use <%! %> called declaration tag.

- Suppose you want to import any packages use <%@ page import = "package.name.*" %> called as directive tag. For multiple packages <%@ page import = "package1.name.*, package2.name2.*" %>


- Suppose you want to print out some information on page, this can be done using `out.println` in scriptlet. In JSP there is another way using <%= contents/variables/expression %> called as expression tag.

![](https://github.com/codophilic/LearnWebDevInJAVA/blob/main/Images/8.jpg)

- So to implement logic we can use servlet , but to implement web page and logic we can use JSP.

- Below `public void _jspService(` method we can see implicit obejcts are defined.

![](https://github.com/codophilic/LearnWebDevInJAVA/blob/main/Images/9.jpg)

![](https://github.com/codophilic/LearnWebDevInJAVA/blob/main/Images/10.jpg)

## JSP Directive

- There are 3 types of directive tags

1. @page -> use to import package

- Syntax: `<%@ page attribute="vaue" attribute="value"..%>`

- Commonly used attributes are:

1. language="scripting language" ( default java )

2. extends="className" (extending a class in servlet for that JSP)

3. import="importList" (packages)

4. session="true|false" (if wanted to use session or not)

5. autoFlush="true|false" (clear Buffer when its full)

6. contentType="ctinfo" (response sent in format of HTML,JSON, XML etc.)

7. errorPage="error_url" (if any error occur redirect to the error_url)

8. isErrorPage="true|alse"

9. info"information"

10. isELIgnored="true|false"

11. isThreadSafe="true|false


2. @include -> includes other JSP files in current JSP file

- - Syntax: `<%@ include file="filename.jsp" %>`

3. @taglib -> external tags provided by other frameworks

- - - Syntax: `<%@ taglib uri="uri" prefix="fx" %>`

## Implicit Object provided by JSP

![](https://github.com/codophilic/LearnWebDevInJAVA/blob/main/Images/11.jpg)

### pageContext

- In JSP, pageContext is an implicit object of type PageContext class.The pageContext object can be used to set,get or remove attribute.

- The entire JSP page is represented by the PageContext object. This object is considered as a method to obtain detail about the page while keeping away from most of the execution information.

- For each request, the credentials to the response and request objects are saved by this pageContext object. By accessing attributes of the pageContext object, the out, session, config, and application objects are obtained.

- This pageContext object further holds information regarding the directives provided to the JSP page, together with the page scope, buffering information, and the errorPageURL.

- By using the pageContext object you can set attributes, get attributes and remove attributes that are present in the different scopes like as page, request, session, and application scopes.

1. page – Page scope is managed by the pageContext object. As a page context object is created for every JSP page, so, every JSP page will have a specific page scope. PageScope is the default scope. The object is accessible only from within the JSP page where it had been created. A page-scope object is stored within the implicit pageContext object. The page scope ends when the page stops executing. If we declare the info in page scope by using pageContext object then that data should have the scope up to this JSP page. Note that when the user refreshes the page while executing a JSP page, new instances will be created of all page-scope object. (Default)

2. request – SRequest scope is managed by the request object. This object is used for reading the request object. If the same request is shared by more than one JSP page those sharing the same request object come under the same request scope. Request Scope begins whenever the request object is created by the servlet container and the request scope ends whenever the request object is deleted by the servlet container.

3. session – Session scope is managed by the session object. The same session object is available to all JSP pages as long as the session is not expired. Whenever a session is expired or session.invalidate() is called then a new session is created for the next requesting page. 

4. application – The application scope is maintained by the application pointing object. Application scope begins whenever the ServletContext implementation object is created. Application scope ends whenever the ServletContext implementation object is deleted. This object is used for reading attributes from ServletContext. The object is accessible from any JSP page that’s utilized in an equivalent Web application because the JSP page that created the thing, within any single Java virtual machine. 

![](https://github.com/codophilic/LearnWebDevInJAVA/blob/main/Images/12.JPG)

## Exception in JSP

-  In JSP,  to perform exception handlin by errorPage and isErrorPage attributes of page directive.

- Basically whenever there is an error or exception in JSP , we can redirect to a JSP page called as error page which will show message.

## JDBC with JSP 

- Here we are using MYSQL Database. First we need to import the package.

- Load and register drivers. Every DBMS has its own driver. For MySQL the driver is `com.mysqljdbc.Driver`. This is a 3rd party library so we need to install its library in the **lib** folder.

- Downloaded the Jar file `https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.27` and placed in `WEB-INF/lib` folder.

- Create connection with DB. Provide Username & password for DB.





# MVC using servlet & JSP

- When we use a JSP page it takes some time to convert into servlets. Whereas servlet is directly run on the server.

-  Therefore to process data it is always recommended to use servlet. JSP use case scenarion comes when a client request for a dynamic view page with static content and not processing.  For only static pages? we have HTML & CSS.

- MVC Pattern stands for Model-View-Controller Pattern. This pattern is used to separate application's concerns.

1. Model - Model represents an object or JAVA POJO carrying data. It can also have logic to update controller if its data changes.

2. View - View represents the visualization of the data that model contains. (JSP)

3. Controller - Controller acts on both model and view. It controls the data flow into model object and updates the view whenever data changes. It keeps view and model separate. (Servlet)

- In Java Programming, the Model contains the simple Java classes, the View used to display the data and the Controller contains the servlets.

- So basically, clients sents a request(`/getStudentInfo`) for a page to the controller(Servlets) which will takes the data inputs from the request, process those data and creates a Model(POJO).  Model is an object with the processed daya done by servlets(`StudentData`). This Model goes to the view(JSP) which takes the model data from controller and display the page to the client(`StudentProfile`). This architecture is called MVC.

- So here , we are processing data using servlets in controller and displaying data using JSP which is view using controller Model which carrys only data.

![](https://github.com/codophilic/LearnWebDevInJAVA/blob/main/Images/13.jpg)

## JSTL (JavaServer Pages Standard Tag Library)

- Initially, Web designers used scriptlets in JSP pages to generate dynamic content. This resulted in readability issues and also made it difficult to maintain the JSP page. Custom tags were introduced to overcome the problems faced in using scriptlets. Although custom tags proved to be a better choice than scriptlets they had certain limitations too Web designers had to spend a lot of time in coding packaging and testing these tags before using them.

- The introduction of JSTL has helped Web designers overcome the shortcomings of custom tags, by encapsulating the common functionalities that the Web designer may need to develop Web pages. These functionalities included the use of tag libraries such as core, SQL and XML. JSTL is Introduced particularly for those Web designers who are not well versed with Java programming.

- Advantages of JSTL:

1. Fast Development.

2. Code Reusability.

3. No need to use a scriptlet tag.

- 5 types of JSTL tags are used:

1. Core tags

2. Function tags

3. Formatting tags

4. XML tags

5. SQL tags

### how to work with JSTL?

- To work with JSTL library we need to download its library and placed it under `WEB-INF/lib` folder.

- To use each tag we need to first use `<%@ taglib uri="uri" prefix="fx" %>` declarative tag.

- Here `uri` will the url and prefix (to denote this is a custom tag and not html tags) for each tag to be used.

- Example: To use Core tag , we use `<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>`. Check more [here](https://www.tutorialspoint.com/jsp/jsp_standard_tag_library.htm)


## Filters

- A filter is an object that is invoked at the preprocessing and postprocessing of a request.

- It is mainly used to perform filtering tasks such as conversion, logging, compression, encryption and decryption, input validation etc.

- The servlet filter is pluggable, i.e. its entry is defined in the web.xml file, if we remove the entry of filter from the web.xml file, filter will be removed automatically and we don't need to change the servlet.

- Example if there are multiple servlet , so when a request goes to servlet it must go via security filter & logging filter, validating request. If any one of the checks fail ,these filter does not allow request to go-ahead and return their own response.

- When we use multiple filters we need to chain them, this channing is done by tomcat server which refers the web.xml which has all these filter configurations. 

- Filter is an Interface

![](https://github.com/codophilic/LearnWebDevInJAVA/blob/main/Images/14.jpg)


# Login Page for an application

- When a website host multiple web pages , where the login credentials are required, we need to main the state of the user through out the website. Http protocols are statelss and we need to maintain the state throughout the series of web pages. So here we use Session Management or cookies.

- In session management , the user data are maintain in the server side. If we use cookie client can manipulate with that cookies. So for login purpose we are using session.

- Suppose on a browser , when we logout our session gets invalid, but when we again click on the back button page on browser, we get redreicted to same page where we had logout. Which we want to prevent when we click on back button on browser. This is due to Https Cache. When we click on back button the page which appears is a cache page. We can prevent this using Https. Headers. 

# File Uploading

- It requires a JAR file


# Files and Folders structure in Eclipse

- In a Eclipse Dynamic Web Project:

1. `.settings`: This folder contains Eclipse-specific configuration settings for your project, such as the formatting rules for your code, the version of Java that you're using, and other settings that are specific to the Eclipse IDE. You typically won't need to modify anything in this folder directly, as these settings can be managed through the Eclipse Preferences menu. Example `org.eclipse.jdt.core.prefs` these settings configure how the Java code formatter should format your code when you save it. In this example, the settings specify things like the amount of whitespace to use around method invocation arguments, assignments, and binary expressions.

2. `.project`: This file contains metadata about your project, such as the name of the project, the type of project (in this case, a Dynamic Web Project), and other configuration settings. You typically won't need to modify this file directly, as these settings can be managed through the Eclipse Project Properties menu.

3. `.classpath`: This file contains the classpath settings for your project, which tells Eclipse where to find the classes and libraries that your project depends on. This includes the location of the JAR files in the WEB-INF/lib folder. You typically won't need to modify this file directly, as these settings can be managed through the Eclipse Project Build Path menu.

4. `META-INF`: This folder is typically used to store metadata and configuration files for the web application, such as the MANIFEST.MF file that contains information about the application's classpath and other details that the JVM needs to run the application correctly. You might also see other files in this folder that are specific to your web application framework or server.

The MANIFEST.MF file contains metadata about your application's JAR file, including its version number, its dependencies on other JAR files, and other attributes that the JVM needs to run the application correctly.

One of the key attributes in the MANIFEST.MF file is the "Class-Path" attribute, which specifies the relative or absolute paths to the JAR files that your application depends on. This attribute is used by the JVM to locate and load the classes and resources that are needed by your application at runtime.

Other attributes in the MANIFEST.MF file might include the name and version of your application, information about the application's main class, and other details that are specific to your application's needs.

Note that the contents of the MANIFEST.MF file can be modified using a variety of tools and build systems, such as Maven or Ant. These tools can automate the process of creating and updating the MANIFEST.MF file based on your project's dependencies and other settings.

5. `WEB-INF`: This folder contains web-related resources that are not directly accessible from the web, such as configuration files, libraries, and servlet classes. Some of the key subfolders that you might see in this folder include:

- classes: This folder is used to store compiled Java classes that are part of your web application.

- lib: This folder is used to store JAR files that your web application depends on.

- web.xml: This file is the deployment descriptor for your web application, and it contains metadata about your servlets, filters, and other web-related resources.

6. `WebContent`: This folder contains the web-related resources that are accessible from the web, such as JSP files, HTML files, images, and other static resources. Some of the key subfolders that you might see in this folder include:

WEB-INF: This folder is used to store web-related resources that are not directly accessible from the web, as described above.
css: This folder might be used to store CSS files that are used to style your web pages.
js: This folder might be used to store JavaScript files that are used to add interactivity to your web pages.


## How the application runs (web server (Tomcat) side loading and initializing)?

- The web server is responsible for loading and initializing the web application based on the information in the deployment descriptor (web.xml file) and other configuration files. Once the web server has initialized the application, it uses the classpath settings to locate and load the application's resources, including the servlet classes and other dependent libraries.

- Once the web server has loaded the necessary resources and initialized the application, it hands off control to the JVM, which then takes over the process of executing the application code. The JVM uses the classpath settings to locate and load the application's classes and libraries, and then executes the code based on the application's logic.

- So, in summary, the web server and the JVM work together to run a web application. The web server is responsible for loading and initializing the application, while the JVM is responsible for executing the application code. The classpath settings play a crucial role in enabling both the web server and the JVM to locate and load the necessary resources to run the application.

-  The .project file is not directly used by the web server when running a web application, it can still be a useful tool for configuring and managing your project within the Eclipse IDE, which can in turn help you to deploy and run the application on a web server more effectively.

## When we just start the web server 

- When you start a web server such as Tomcat, the server will read the configuration information from the web.xml file and initialize the web application accordingly. This initialization process typically includes loading any servlets or other web components that are defined in the application, as well as setting up any configuration parameters or resource references that the application needs to function.

- The .classpath file is used by Eclipse to determine which Java class files and libraries are needed to build and run your web application. When you click on the "Run" button in Eclipse, the IDE will use the information in the .classpath file to compile your Java source code into class files, and then package those class files into a WAR file that can be deployed to the server.

- Once the WAR file has been deployed to the server and the web application has been initialized, the server will be ready to process incoming requests from clients. When a client sends a request to the server, the server will use its own internal routing mechanisms to determine which servlet or other web component should handle the request. The server will then invoke the appropriate Java class to handle the request, and the JVM will execute the code in that class.

- So to summarize, the web server loads and initializes the web application based on the configuration information in web.xml, and then waits for incoming requests from clients. When a request comes in, the server uses its own routing mechanisms to determine which Java class should handle the request, and the JVM executes the code in that class. The .classpath file is used by Eclipse to compile and package your Java source code into a deployable WAR file, but it is not used by the server at runtime.


## When we click on Run button in eclipse

- When you click on the Run button in Eclipse to run a servlet, several steps happen behind the scenes. Here's a simplified overview of the process:

- The Java source code for your servlet is compiled into bytecode (.class) files, which are stored in the WEB-INF/classes folder.

- The compiled bytecode files are packaged into a Java Archive (JAR) file, which is stored in the WEB-INF/lib folder along with any external libraries that your servlet depends on.

- The web server (such as Apache Tomcat or Jetty) starts up and reads the configuration information from the web.xml file, which is located in the WEB-INF folder. This file contains information about your servlet, such as the URL mapping and initialization parameters.

- When a request is received that matches the URL mapping for your servlet, the web server loads the servlet class from the WEB-INF/classes folder and creates an instance of the servlet.

- The web server calls the init() method of your servlet to perform any initialization tasks that your servlet needs to do before it can handle requests.

- When a request is received for your servlet, the web server calls the appropriate method (such as doGet() or doPost()) on your servlet instance, passing in the request and response objects as parameters.

- Your servlet processes the request, generates a response, and sends it back to the client through the response object.

- So in summary, when you click on the Run button in Eclipse, the web server starts up and reads the configuration information from the web.xml file, then loads and initializes your servlet. When a request is received, your servlet processes it and generates a response that is sent back to the client. The folders that are involved in this process include WEB-INF/classes, WEB-INF/lib, and WEB-INF/web.xml.



## src/main folder

- The src/main folder is used to hold the main source code and resources for your project. If you delete this folder, you will lose all of your main source code and resources, which will likely cause your application to fail to compile or run correctly.

## Why there is no main method in servlet?

- Servlets don't have a main method like standalone Java applications. Instead, servlets are components that run within a web server and are managed by the web server's servlet container.

- When a servlet container starts up, it initializes the servlets that are defined in the web application's deployment descriptor (usually the web.xml file). The servlet container manages the lifecycle of the servlets, including creating instances of the servlets and invoking their methods to handle incoming requests from clients.

- The main entry point for a servlet is the service method, which is called by the servlet container for each incoming request. The service method then delegates to other methods like doGet or doPost to handle the specific type of request.

- So while servlets don't have a main method, they have a well-defined lifecycle and a set of methods that are called by the servlet container to handle incoming requests.


## Server Folder structure

- The Server folder in Eclipse typically contains information about the server(s) that you have configured within the IDE. This folder is created when you add a server to Eclipse using the Servers view, which is used to manage your server configurations.

- The Server folder itself does not contain any specific files or subfolders that are relevant to running your web application. Instead, it serves as a container for storing server-specific configuration information, such as the server's runtime environment, the ports that it uses, and any other settings that are specific to the server.

- Inside the Server folder, you will typically see one or more subfolders, each of which corresponds to a different server configuration that you have defined in Eclipse. These subfolders contain information about the specific server, such as the server's name, version, and runtime environment. In addition, they may contain additional configuration files, such as server-specific deployment descriptors or configuration files.

- When you run a web application in Eclipse, the IDE will typically deploy the application to a server that you have configured within the Servers view. The IDE will use the configuration information in the Server folder to determine which server to use and how to deploy the application to that server. Once the application is deployed, the server will use its own configuration settings to manage the application's runtime environment and process incoming requests from clients.


# Logging using log4j/log4j2 (LOgging Utility for JAVA)

- log4j is a reliable, fast and flexible logging framework (APIs) written in Java, which is distributed under the Apache Software License. log4j is a popular logging package written in Java. log4j has been ported to the C, C++, C#, Perl, Python, Ruby, and Eiffel languages.

- It is designed to handle Java Exceptions from the start.

- Just like in Logging API java utils, it uses multiple levels, namely ALL, TRACE, DEBUG, INFO, WARN, ERROR and FATAL.

- log4j has three main components:

1. *loggers:* Responsible for capturing logging information. This takes message from the java application and passes to the appenders.

2. *appenders:* Responsible for publishing logging information to various preferred destinations like in a file or console or DB. Appender takes the data and goes to the layout. After getting the require style it stores the data in the destination.

3. *layouts:* Responsible for formatting logging information in different styles.

- Logging does have its drawbacks also. It can slow down an application. If too verbose, it can cause scrolling blindness. To alleviate these concerns, log4j is designed to be reliable, fast and extensible.

## Core components and its different methods

1. **Logger:** The Logger is the top-level layer which provides the Logger object. The Logger object is responsible for taking logging information, and they are stored in a namespace hierarchy.

- Logger is a class, which is available in org.apache.log4j.*

- We have to create Logger object one per java class
Logger component is used to enable the log4j in our java class

- Logger methods are used to generate log statements in a java class instead of SOPLS.

- In order to get an object of Logger class, we need to call a static factory method which will give an object as a return type

- We have to create a Logger object right after our class name. For example: `static Logger log = Logger.getLogger(YourClassName.class.getName())`

- Logger object has some methods; these methods are used to print the status of our application. These methods are:

```
debug()
info()
warn()
error()
fatal()
```

- These all methods are approximately the same. Priority order of these methods is `debug < info < warn < error < fatal`

2. **Appender:** The appender is the lower layer component, which provides Appender objects. The Appender object is responsible for publishing logging information to various preferred destinations such as a file, database, console, Unix Syslog, etc.

- Logger classes are used to generate statements in different levels, and Appender takes these logs and stores in some database or files.

- Appender is not a class, it is an interface.

- Different types of appenders are

1. *FileAppender:* used to append log events to a file. It supports two more appender classes:

- RollingFileAppender: Extends FileAppender class to back up the log files when they reach a certain size.

- DailyRollingFileAppender: Extends FileAppender class so that the underlying file is rolled over at a user-chosen frequency.

2. *ConsoleAppender:* Appends log events to System.err or System.out using a layout specified by the user. The default console is System.out.

3. *JDBCAppender:* Used for Database.

4. *SMTPAppender:* Used to send an email when a specific logging event occurs, typically on errors or fatal errors.

5. *SocketAppender:* Used for remote storage.

6. *SyslogAppender:* Sends messages to a remote Syslog domain.

7. *TelnetAppender:* Specializes in writing to a read-only socket.

8. *WriterAppender:* Used to append log events to a Writer or an OutputStream depending on the user's choice.

- Different methods used inside Appenders are:

1. `setThreshold(Level level):` Sets the minimum severity level for log messages that will be accepted by the appender.

2. `setLayout(Layout layout):` Sets the layout that will be used to format log messages.

3. `setFilter(Filter filter):` Sets a filter that can be used to selectively discard log messages.

4. `start():` Starts the appender.

3. **Layout:** The layout layer provides Layout objects which are used to format logging information in different styles. It is used to provide support to appender objects before publishing logging information.

- Layout objects play an important role in publishing logging information in a way, i.e., human-readable and reusable.

- The layout component defines the format in which the log statements are written into the destination repository by the appender.

- There are different types of layout classes in log4j:

1. `SimpleLayout:` It is used to format the output in a very simple manner; it prints the Level, then a dash "-" and then the log message.

2. `PatternLayout:` Used to format the output based on conversion pattern specified or if none is specified, the default conversion pattern is considered.

3. `HTMLLayout:` It formats the output as an HTML table.

4. `XMLLayout`

- Some of the Layout methods are :

1. `toSerializable(LogEvent event):` Formats a LogEvent into a Serializable object that can be sent over a network or stored in a file.

2. `getContentFormat():` Returns a string that describes the format of the layout.

3. `getHeader():` Returns a string that should be appended to the beginning of the log file.

4. `getFooter():` Returns a string that should be appended to the end of the log file.


## Support Objects

1. *Level Object:* The Level object defines the granularity and priority of any logging information. There are seven levels of logging defined within the API: OFF, DEBUG, INFO, ERROR, WARN, FATAL, and ALL.

2. *Filter Object:* The Filter object is used to analyze logging information and make further decisions on whether that information should be logged or not.

- An Appender objects can have several Filter objects associated with them. If logging information is passed to a particular Appender object, all the Filter objects associated with that Appender need to approve the logging information before it can be published to the attached destination.

3. *ObjectRenderer* The ObjectRenderer object is specialized in providing a String representation of different objects passed to the logging framework. This object is used by Layout objects to prepare the final logging information.

4.  *LogManager* The LogManager object manages the logging framework. It is responsible for reading the initial configuration parameters from a system-wide configuration file or a configuration class. Configuring log4j involves assigning the Level, defining Appender, and specifying Layout objects in a configuration file.

- The log4j.properties file is a log4j configuration file which keeps properties in key-value pairs. By default, the LogManager looks for a file named log4j.properties/ log4j.xml in the CLASSPATH.

- Example 

```
# Example properties file
database.url = jdbc:mysql://localhost:3306/mydatabase
database.user = myusername
database.password = mypassword
log4j.rootLogger = INFO, console
log4j.appender.console = org.apache.log4j.ConsoleAppender
log4j.appender.console.layout = org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern = %d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n

```

- In this example, the properties file contains several key-value pairs. The first three key-value pairs specify the URL, username, and password for a database. The remaining key-value pairs configure Log4j2. For example, the log4j.rootLogger property sets the root logger's log level to INFO and its appender to "console". The log4j.appender.console property specifies that log messages should be sent to the console using a ConsoleAppender. The log4j.appender.console.layout property specifies that the layout for the ConsoleAppender should be a PatternLayout, which formats log messages using a pattern string.

- This properties files are defined using the references.

- https://logging.apache.org/log4j/2.x/manual/configuration.html#Properties

- https://logging.apache.org/log4j/2.x/manual/configuration.html#Properties_Reference

- https://logging.apache.org/log4j/2.x/manual/configuration.html#Configuration_Examples

- Behind the scenes, the Log4j2 configuration system reads your configuration file and constructs a corresponding set of Java objects that represent the configured loggers, appenders, and layouts. The log4j.rootLogger property you specified is used to create a LoggerConfig object for the root logger. The INFO value you specified is used to set the root logger's log level to INFO, and the Console value is used to create a ConsoleAppender object and associate it with the root logger.

- When you call a logging method on a Logger object, such as logger.info("Hello, world!"), the Log4j2 system uses the configuration information to determine whether the log message should be logged, and if so, which appenders to send it to and how to format it.

- So, in summary, the Log4j2 configuration file is a way to specify the configuration of the logging system using a simple and concise syntax. The configuration system then creates the appropriate Java objects to implement the configuration, and the Logger objects you obtain from the LogManager use those objects to log messages.

- When you define a Log4j2 configuration file, the LogManager reads the file and creates the corresponding LoggerConfig, Appender, and Layout objects. You do not need to explicitly create these objects in your code; instead, you can obtain a Logger object from the LogManager and use it to log messages.

- The LogManager uses the configuration information to determine which LoggerConfig objects are associated with each Logger, and which Appender and Layout objects are associated with each LoggerConfig. When you call a logging method on a Logger object, the LogManager uses this information to determine how to handle the log message.

- This separation of configuration and logging logic is one of the strengths of the Log4j2 system.

- You can specify multiple configuration files by setting the log4j.configurationFile system property. This property can contain a comma-separated list of configuration file locations. Log4j will merge the configurations from all the specified files into a single configuration.

- For example, if you have two configuration files named log4j2.properties and log4j2-extra.properties in your classpath. 

![](https://github.com/codophilic/LearnWebDevInJAVA/blob/main/Images/15.jpg)

## Working of Log4j and all its components

- When you use Log4j with a properties file configuration, the LogManager reads the configuration file and creates the corresponding LoggerConfig, Appender, and Layout objects. Here is an overview of the steps involved in the logging process using Log4j with properties configuration:

1. Load the configuration file: The first step is to load the Log4j2 configuration file, which is typically named "log4j2.properties" or "log4j2.xml". This file specifies the log levels, appenders, and other configuration options for your application's logging system.

2. Create a Logger object: To log messages, you need to obtain a Logger object from the LogManager. You can do this using the static LogManager.getLogger() method, which takes the name of the logger you want to use. The logger name typically corresponds to the name of the class that is doing the logging. For example:

```
private static final Logger logger = LogManager.getLogger(MyClass.class);
```

3. Log a message: Once you have a Logger object, you can use its logging methods to log messages. These methods correspond to the log levels defined in the configuration file (e.g. debug(), info(), warn(), error(), fatal()). For example:

```
logger.info("This is an informational message");
```

4. Determine the appropriate LoggerConfig: When you call a logging method on a Logger object, Log4j uses the logger name to determine which LoggerConfig to use. The LoggerConfig specifies the log level and appenders for the logger. If there is no LoggerConfig with an exact match to the logger name, Log4j will use the root LoggerConfig.

5. Determine the appropriate Appender: Once the appropriate LoggerConfig is determined, Log4j uses it to determine which Appender or Appenders to use. An Appender is responsible for writing log messages to a specific destination (e.g. console, file, database). If multiple Appenders are specified, Log4j will use them in the order they are listed.

6. Format the log message: Once the appropriate Appender or Appenders are determined, Log4j uses the Layout defined for the Appender to format the log message. The Layout specifies the format of the log message, including things like the date, time, log level, logger name, and message.

7. Write the log message: Finally, Log4j writes the formatted log message to the appropriate destination(s) using the Appender(s) specified in the configuration file.

Here's an example of a simple Log4j properties file configuration:

```
log4j.rootLogger=INFO, console

log4j.appender.console=org.apache.log4j.ConsoleAppender
log4j.appender.console.layout=org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern=%d [%t] %-5p %c - %m%n

```

- Log4j2 has several improvements over Log4j, including better performance, improved reliability, and new features such as support for lambda expressions in logging statements. Log4j2 also has a more flexible configuration system that allows you to configure your logging system using XML, JSON, YAML, or properties files.

- To use log4j2 we need to make sure the code must have the core jars which are 

```
log4j-api-2.20.0.jar
log4j-core-2.20.0.jar
```

# JDBC (Java DataBase Connectivity)

- JDBC stands for Java Database Connectivity. It is a Java API that provides a standard way to access relational databases from Java programs. JDBC allows Java programs to interact with a wide range of database management systems, such as MySQL, Oracle, SQL Server, and many others.

- JDBC is required because databases are essential components of most modern software applications, and Java is one of the most popular programming languages used to develop such applications. JDBC provides a way for Java programs to connect to databases, execute SQL statements, and retrieve results.

- JDBC is primarily designed for relational databases, which are databases that store data in tables with columns and rows. Examples of popular relational databases that support JDBC include MySQL, Oracle, SQL Server, and PostgreSQL.

- However, there are some non-relational databases that also support JDBC, such as Apache Cassandra, which is a NoSQL database. These databases typically provide a JDBC driver that can be used to connect to the database using the JDBC API.

- It's important to note that not all types of databases are designed to work with JDBC. For example, graph databases like Neo4j typically have their own APIs and query languages that are optimized for working with graph data. In such cases, it may be more appropriate to use a specialized library or framework that is designed for graph databases rather than trying to use JDBC.

- Overall, while JDBC is primarily designed for relational databases, there are some non-relational databases that also support it. However, the suitability of JDBC for a particular database depends on the specific features and query language of that database.

- Alternative approaches to JDBC include Object-Relational Mapping (ORM) frameworks such as Hibernate and JPA (Java Persistence API). These frameworks provide a higher level of abstraction over database access than JDBC, making it easier to work with databases without having to write SQL queries directly.

- The choice between using JDBC and an ORM framework depends on the requirements of the application. For simple applications that only require basic database operations, JDBC may be sufficient. However, for more complex applications that require advanced mapping of objects to database tables, an ORM framework may be a better choice.


## What are Drivers in JDBC?

- In simple terms, a JDBC driver is a software component that allows a Java application to communicate with a database. It acts as a bridge between the Java application and the database, providing the necessary implementation of the JDBC API for a specific database management system (DBMS).

- The JDBC driver performs the following tasks:

1. Establishes a connection to the database: The driver establishes a network connection to the database and authenticates the user.

2. Sends SQL statements to the database: The driver converts SQL statements issued by the Java application into a format that the database can understand.

3. Retrieves results from the database: The driver retrieves results from the database and returns them to the Java application.

- Types of Drivers:

- *Type 1:* JDBC-ODBC Bridge Driver
The Type 1 driver is also known as the JDBC-ODBC bridge driver. It uses the ODBC (Open Database Connectivity) API to communicate with the database. The ODBC driver acts as a mediator between the Java application and the database. The Type 1 driver is typically used for testing purposes or when a native JDBC driver is not available for the database being used. Example databases: Microsoft Access, Microsoft Excel

- *Type 2:* Native API Driver
The Type 2 driver is also known as the native-API driver. It communicates directly with the database using a vendor-specific API. This driver requires the installation of vendor-specific client libraries on the client machine. Example databases: Oracle, Sybase, Informix

- *Type 3:* Network Protocol Driver
The Type 3 driver is also known as the middleware driver. It communicates with the database server through a middleware layer or a middle-tier server. The Java application communicates with the middleware using a protocol that is specific to the driver. The middleware then communicates with the database server using a database-specific protocol.
Example databases: IBM DB2, Microsoft SQL Server

- *Type 4:* Native Protocol Driver
The Type 4 driver is also known as the thin driver. It communicates directly with the database using a vendor-specific network protocol. This driver does not require the installation of any middleware or vendor-specific client libraries (MySQL etc.). Example databases: MySQL, PostgreSQL, Oracle

- Note that some databases may require the use of a specific type of driver or may have multiple driver options available. The choice of driver depends on factors such as the database being used, the performance requirements of the application, and the availability of the driver for the specific database and platform.


## Overview of how JDBC works

1. Load the JDBC driver: Before you can connect to a database using JDBC, you need to load the JDBC driver for the database you're using. This is typically done using the `Class.forName()` method, which loads the driver class into memory.

2. Establish a database connection: Once you have loaded the driver, you can use the `DriverManager.getConnection()` method to establish a connection to the database. This method returns a Connection object, which represents the connection to the database.

3. Create a statement: Once you have a connection to the database, you can create a Statement object using the `Connection.createStatement() ` method. This statement object represents a SQL statement that you want to execute on the database.

4. Execute the statement: Once you have created a statement object, you can use its various methods to execute SQL statements on the database. For example, you can use the `Statement.executeQuery()` method to execute a SELECT query and retrieve the results, or use the `Statement.executeUpdate()` method to execute an INSERT, UPDATE, or DELETE statement.

6. Process the results: If you execute a SELECT query using a statement, you will get a ResultSet object that contains the results of the query. You can use the various methods of the ResultSet object to access the data in the result set and process it as needed.

7. Close the resources: Once you are done with the database interaction, you should close the resources that you have used, such as the ResultSet, Statement, and Connection objects. This is typically done using the `close()` method of the respective objects.

- Overall, the JDBC API provides a standard way to interact with relational databases from Java code, allowing you to execute SQL statements, retrieve results, and perform other database operations programmatically.

- For PostgreSQL JDBC [document](https://jdbc.postgresql.org/documentation/use/) .




