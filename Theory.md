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



















