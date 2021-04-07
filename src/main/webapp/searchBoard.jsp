<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <div class="px-4 py-4 h-screen rounded-md bg-yellow-100 max-w-7xl mx-auto shadow-xl ring-2 ring-gray-400">
                <div class="py-5 rounded-md bg-gray-700 shadow-xl ring-2 ring-gray-400">
                    <table class="min-w-full divide-y divide-gray-200">
                        <thead class="bg-gray-50">
                        <tr>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                ID
                            </th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                Name
                            </th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                Position
                            </th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                Status
                            </th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                Holiday/year
                            </th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                Holiday used
                            </th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                Holiday remain
                            </th>
                            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                Edit
                            </th>
                        </tr>
                        </thead>
                        <tbody class="bg-white divide-y divide-gray-200">
                        <c:forEach var="worker" items="${worker}">
                            <tr>
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                                    ${worker.workerID}
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap">
                                    <div class="flex items-center">
                                        <div class="flex-shrink-0 h-10 w-10">
                                            <img class="h-10 w-10 rounded-full"
                                                 src="https://filetandvine.com/wp-content/uploads/2015/11/buddy-placeholder-square.jpg"
                                                 alt="">
                                        </div>
                                        <div class="ml-4">
                                            <div class="text-sm font-medium text-gray-900">
                                                    ${worker.name}
                                            </div>
                                            <div class="text-sm text-gray-500">
                                                    ${worker.email}
                                            </div>
                                        </div>
                                    </div>
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap">
                                    <div class="text-sm text-gray-900">${worker.workPlace}</div>
                                    <div class="text-sm text-gray-500">${worker.position}</div>
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap">
                                <span class="px-2 inline-flex text-xs leading-5 font-semibold rounded-full bg-green-100 text-green-800">
                                        ${worker.status}
                                </span>
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                                        ${worker.holidayInAYear}
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                                        ${worker.usedHoliday}
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                                        ${worker.remainHoliday}
                                </td>
                                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                                    <a href="${pageContext.request.contextPath}/editBoard?workerID=${worker.workerID} " class="text-indigo-600 hover:text-indigo-900">Edit</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="rounded-md bg-gray-700 py-1 my-5 shadow-xl ring-2 ring-gray-400">
                    <form action="searchBoard" method="POST" class=" text-white grid grid-cols-1 gap-2 my-5 w-2/4">
                        <div class=" mx-5">
                            <label class="text-l flex font-serif" for="searchOption">Search: </label>
                            <select class=" text-gray-700 w-full text-xl rounded-lg py-1.5 font-serif" id="searchOption" name="searchOption">
                                <option>Name</option>
                                <option>E-mail</option>
                                <option>Workplace</option>
                                <option>Position</option>
                                <option>Status</option>
                            </select>
                        </div>
                        <div class=" mx-5">
                            <input class="w-full border-2 rounded-lg py-1 text-gray-700 font-serif" id="searchInput" name="searchInput">
                        </div>
                        <div class="flex mx-5 gap-2">
                            <button class="text-white text-xl rounded-lg bg-gray-900 py-1 font-serif w-36"
                                    type="submit">Search
                            </button>
                            <label class="w-full rounded-lg py-1 text-xl text-red-500 font-serif">${searchError}</label>
                        </div>
                    </form>
                </div>
            </div>
        </main>
        <div class="bg-gray-700 rounded-md py-9 max-w-7xl mx-auto shadow-xl ring-2 ring-gray-400">
        </div>
    </div>
</div>
</body>
</html>