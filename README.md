# SpringSecurityBattleGround
### Who assigned this default username and password? 🤔

Once we add Spring Security to our project, it starts working out of the box without any additional configuration. After that, if you try to access any of your `routes` or `endpoints`, you'll see the default login page. The default username is `user`, and the password is generated at runtime — you can find it in the logs.
But the real question is: who’s responsible for setting this default username and password? Obviously, the FBI... right? 🙂 Unfortunately, it’s just a simple class under the **`org.springframework.boot.autoconfigure.security package`**.

**SecurityProperties.java**
- The SecurityProperties class in Spring Boot is part of the framework's **auto-configuration mechanism** for Spring Security. It provides configuration properties that allow developers to customize default security settings.
- SecurityProperties annotated with `@ConfigurationProperties(prefix = "spring.security")`, meaning it maps externalized configuration properties prefixed with `spring.security` to this class.
- `SecurityProperties.User` represents user-specific properties, such as username and password.
- By default, Spring Boot creates **a single in-memory user with random password.** These can be customized using properties like.
  - `spring.security.user.name`
  - `spring.security.user.password`
- Default Password Log: `Using generated security password: 8cc2e3e0-4f6b-4a24-bd8a-4b378be7c3e7`

**SecurityProperties.java**
```java
package org.springframework.boot.autoconfigure.security;

@ConfigurationProperties(prefix = "spring.security")
public class SecurityProperties {

	//......

	public static class User {

		/**
		 * Default user name.
		 */
		private String name = "user";

		/**
		 * Password for the default user name.
		 */
		private String password = UUID.randomUUID().toString();

		/**
		 * Granted roles for the default user name.
		 */
		private List<String> roles = new ArrayList<>();

		private boolean passwordGenerated = true;

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return this.password;
		}

		public void setPassword(String password) {
			if (!StringUtils.hasLength(password)) {
				return;
			}
			this.passwordGenerated = false;
			this.password = password;
		}

		public List<String> getRoles() {
			return this.roles;
		}

		public void setRoles(List<String> roles) {
			this.roles = new ArrayList<>(roles);
		}

		public boolean isPasswordGenerated() {
			return this.passwordGenerated;
		}

	}

}

```
### Servlet Containers.
A Servlet Container (also known as a web container or servlet engine) is a core component of a web server or application server that provides the runtime environment for Java Servlets. It implements the Java Servlet Specification and is responsible for managing the entire lifecycle of servlets—from loading and initialization to handling requests and eventual destruction.
It also takes care of:
- Creating HttpServletRequest and HttpServletResponse objects.
- Routing incoming HTTP requests to the correct servlet.
- Managing user sessions using cookies or URL rewriting.
- Handling multithreading so multiple users can be served concurrently.
In short, it’s the behind the scenes manager that keeps your Java web app running smoothly.

**Real Life Analogy**
Think of the Servlet Container as a restaurant manager in a Java-themed diner 🍽️:
- A customer **(the browser)** walks in and places an order **(HTTP request)**.
- The manager **(Servlet Container)** grabs the right chef **(Servlet)**, gives them the order **(request object)**, and waits for them to cook up a dish **(response)**.
- Once it’s ready, the manager serves it back to the customer.
- The manager also remembers who the customer is **(session management)**.

 **Example Of Servlet Container**
 - Apache Tomcat.
 - Jetty.
 - JBoss.
 - WebLogic.

### Filters.
A Filter is a Java class that intercepts HTTP requests and responses to perform **pre-processing or post-processing** tasks. Filters are part of the Java Servlet API and are typically used for tasks like *authentication*, *logging*, *compression*, or *modifying request/response data*.

**Resources**
- https://www.scaler.com/topics/servlet-life-cycle/
- https://www.slainstitute.com/java-servlets-building-web-applications-using-java/
