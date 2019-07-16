# CareerJetRecommender

## SETTING UP THE PROJECT IN YOUR IDE:
1) Import the project into your IDE like you normally would.
2) Add all the .jars in the jars folder provided to your project.

## RUNNING THE PROJECT:
1) Run HomePage.java.

![Home Page](https://github.com/rguan1/CareerJetRecommender/blob/master/Resources/1.png)

2) Click on Search (the big gray square). Note that clicking on Java Swing is strange so it may take a couple of clicks (or harder clicks) for the change to happen.

3) Input your search query. The inputs you see are the default inputs that serve as example. For job title, simply input a job title. For keywords, input things like skills required and company. For location, input a state, country, continent, or “world” if you want a worldwide search result thread. Select what you want the scraper to scrape by (date vs. salary), and input the number of jobs that you want to be displayed. Click “Search” when you have finished inputting your
query. You know when the program is running when your mouse switches to a waiting mouse and the top of the window says “Loading...”. This search will take a couple of minutes as the engine is going to the API and scrape for jobs and their descriptions (so the speed will depend on your internet speed).

![Search](https://github.com/rguan1/CareerJetRecommender/blob/master/Resources/2.png)

4) A couple of things can happen when
you click “search”. If your inputs
are unlikely (astronaut with bacon
as keyword in Missouri), you may receive a pop up screen telling you that there are no matches found, in which case you can close that screen and input a different set of criteria. Else you will receive a screen that display all your results:

![Results](https://github.com/rguan1/CareerJetRecommender/blob/master/Resources/3.png)

5) Now you have an option to display even more results based on either/or job title and company. The job titles will be all the jobs that are on your current matched list that you see, and the companies are the places that those jobs belong to.

![Options](https://github.com/rguan1/CareerJetRecommender/blob/master/Resources/4.png)

You can either select a job title, a company, or both to see more search results. However, if you leave both blanks (if you chose “None” for both), then an error screen will pop up and prompt you to select at least one.

6) Once you are done selecting your criteria, click on “More jobs” to see more matches. Please wait a couple of minutes for the scraper to retrieve necessary information and for the engine to calculate results. You know when search is in progress when the mouse is a loading mouse:
