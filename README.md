Having scalability as it’s main feature, the first decision was to separe the application in modules. the app was separated in application layer, where the user will interfaces with the application and its web service’s layer, that contains the REST calls to the repository used. Based on the open-closed principle, the first one depends on the second, using the rest services but making no changes on any of the module’s components. This immutability is secured by the Interface Segregation Principle, asserting that the only communication between then is trough an interface.

In the same hand, preserving this layer made it possible to apply tests to make sure the requests will return as intended.  This was also the reason that was decided to use a proper model in the application layer, that would separate itself from the one from the request result and be able to be modified. That was easily achieved by the adapter pattern.

  

>For the app, it was used the following libraries:
### Data Module

**Retrofit** : there is not so much to talk about Retrofit, as is one of the most famous REST libraries for android. Is tested and true to me and is the rest library that I am most comfortable to use. Also, is my go to choice since it has integration with rxJava/rxAndroid.

  

**rxJava** : this extremely powerful library turned things a lot easier to me, making data transformation a walk in the park and providing a very elegant solution on PagedMoviesListDataSource class, where I was able to zip the upcoming movies and the genres call.

  

**glide** : while Picasso is my go to choice, this time glide was a better option because of it’s option to generate thumb nails. Since the application would be basically a list, it could make the loading less resource intensive while drawing so many viewholders.

  

### Application Module:

**KOIN** : a dependency injection that is a lot simpler than DAGGER. While being lightweight, it also conforms better with Kotlin’s functional programming.
