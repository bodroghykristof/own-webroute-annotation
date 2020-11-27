# Own Webroute Annotation

## Intro

Many bigger frameworks in Java use annotations and reflection in operation.
My goal is to create a routing annotation similar to the @app.route decorator in flask or @WebServlet("/hello") in Java
and use it in a lightweight web application.

## What am I attempting to learn?

- creating custom annotations
- using built-in Java server
- using reflection
- handling web-routes in a more efficient way

## Tasks

1. Create custom annotation `@WebRouter`
2. Create a number of decorated methods in `Routes` class
3. Handle requests in `Server` class
4. User reflection to call the corresponding callback
5. Check request method and broaden the scope of `@WebRouter`
6. Optimize webserver by using `Map` data structure
