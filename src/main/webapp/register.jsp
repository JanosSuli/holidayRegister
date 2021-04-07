<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Holiday Register - Register</title>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 text-center">

<div class="bg-gray-100 text-center">
    <div class="px-4 py-4 h-screen rounded-md bg-yellow-100 max-w-7xl mx-auto shadow-xl ring-2 ring-gray-400">
        <div class="bg-gray-700 text-white mx-auto text-center w-1/2 py-5 shadow-2xl rounded-2xl max-w-2xl my-72 ring-2 ring-gray-400">
        <form action="register" method="POST">
            <h3 class="text-2xl font-serif">Register</h3>
            <p class="text-red-600 font-serif text-xl">${RegistrationError}</p>
            <div class="grid grid-cols-1 gap-4 mx-8 my-5">
                <label class="text-xl flex item-center font-serif" for="username">Username:</label>
                <input class="w-full border-2 rounded-lg py-1 text-gray-700" id="username" type="text" name="userName">

                <label class="text-xl flex item-center font-serif" for="password">Password:</label>
                <input class="w-full border-2 rounded-lg py-1 text-gray-700" id="password" type="password"
                       name="password">

                <label class="text-xl flex item-center font-serif" for="confirm-password">Confirm Password:</label>
                <input class="w-full border-2 rounded-lg py-1 text-gray-700" id="confirm-password" type="password"
                       name="confirmPassword">
            </div>
            <div class="py-5">
                <button class="text-xl rounded-lg bg-gray-800 px-8 py-1 font-serif w-36" type="submit">Register</button>
            </div>
        </form>
    </div>
    </div>
</div>

</body>
</html>