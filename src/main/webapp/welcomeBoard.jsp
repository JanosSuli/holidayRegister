<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Holiday Register - Dashboard</title>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>

<%
    if (session.getAttribute("userName") == null) {
        response.sendRedirect("/login");
    }
%>

<div class="bg-gray-100">
    <div class="mx-auto rounded-lg max-w-7xl">
        <nav class="bg-gray-700 rounded-md shadow-xl ring-2 ring-gray-400">
            <div class="px-4 sm:px-6 lg:px-8">
                <div class="flex items-center justify-between h-16">
                    <div class="ml-5 space-x-5 flex flex-row">
                        <a href="${pageContext.request.contextPath}/searchBoard"
                           class="bg-gray-900 text-white w-32 px-3 py-2 rounded-md text-lg text-center font-serif inline-block">Search</a>
                        <a href="${pageContext.request.contextPath}/addBoard"
                           class="bg-gray-900 text-white w-32 px-3 py-2 rounded-md text-lg text-center font-serif inline-block">Add</a>
                    </div>
                    <div class="mr-5 space-x-5 flex flex-row">
                        <div class="flex flex-col bg-gray-900 text-white w-32 rounded-md">
                            <label class="text-center font-serif text-sm">Logged in: </label>
                            <label class="text-center font-serif text-sm">${userName}</label>
                        </div>
                        <a href="/logout"
                           class="bg-gray-900 text-white w-32 px-3 py-2 rounded-md text-lg text-center font-serif inline-block">Log
                            out</a>
                    </div>
                </div>
            </div>
        </nav>
        <main>
            <div class="px-4 py-4 h-screen rounded-md bg-yellow-100 shadow-xl ring-2 ring-gray-400">
                <div class="py-5">
                    <img class="rounded-3xl shadow-xl ring-2 ring-gray-400"
                         src="img/welcome.jpg" alt="">
                </div>
            </div>
        </main>
        <div class="bg-gray-700 rounded-md py-9 max-w-7xl mx-auto shadow-xl ring-2 ring-gray-400">
        </div>
    </div>
</div>
</body>
</html>
