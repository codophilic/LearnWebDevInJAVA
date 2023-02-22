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