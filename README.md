<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JHotel interface official website</title>
    <link rel="stylesheet" href="styles.css" />
    <style>
        body {
    width: 100%;
    height: 100vh;
    margin: 0;
    background-image: url(iguazu-warerfallsIII.jpg);
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: 100% 100%;
    font-family: Roboto;
    font-size: 20px;
    color: rgb(175,255,55);
}
nav{
    padding: 10px;
    background-color: rgba(0, 0, 0, 0.5);
    display: flex;
    flex-direction: row;
    justify-content: flex-end;
}

nav h1{
    margin: 10px auto;
    text-align: center;
    padding-top: 10px;
    text-shadow:2px 2px #000000;
    align-self: center;
}
section{
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
    width: 50%;
    min-width: 500px;
    margin: 20px auto;
    padding-bottom: 0px;
}
section img{

}
section p{
    text-align: justify;
    color: #ffffff;
    text-shadow: 1px 1px #000000 ;
}
@media(max-width: 600px){
    section img{
        width: 400px;
    }
    section p{
        width: 400px;
    }
}
    </style>
</head>
<body>
    <nav><h1>JHotel interface official website</h1></nav>
    <section>
        <img src="interfaz-beta.png" alt="beta image">
        <p class="article">Hello, I'm Jhony Souza, a junior Frontend developer, I live in Puerto Iguazú, a city in the province of Misiones, in the extreme northeast of Argentina. This town is located 14 km from the Iguazú Falls, one of the Seven Natural Wonders of the World.
            This project is about a user interface for the Java Hotel Iguazu, the most prestigious hotel in the area, which receives thousands of travelers from all over the world throughout the year, seven days a week, 24 hours a day.
            The interface was created with the function of facilitating the work of the hotel receptionist, which seeks to provide assistance and control in their daily cashier tasks, stock management, check-in, check-out and rooming.
        </p>
    </section>
    
    <footer></footer>
</body>
</html>
