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

- So the request is of addition and we need to call add servlet.So on the Tomcat server there is a file web.xml which is called Deployment Descriptor.

- This web.xml maps every request to its respective servlets. There can be multiple request asking for same servlet so such scenario needs to be configured in web.xml. 

![](https://github.com/codophilic/LearnWebDevInJAVA/blob/main/Images/2.jpg)

# Create servlet

- Servlets are normal java class which extends HttpServlet class.

- This HttpServlet will provide all features like accepting/processing the request and sending response to the server.

- The response can be in any format like JSON,XML or html.

- No matter what is the reponse format , it goes back as an response object.

- In the latest version , instead of referring web.xml file we can have Annotations which provides the same mapping like xml files.

![](https://github.com/codophilic/LearnWebDevInJAVA/blob/main/Images/3.jpg)


