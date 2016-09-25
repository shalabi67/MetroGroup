# MetroGroup
## Requirements
 URL consists of three parts(protocol, domain, and path) separated by two tokens(://, and /). Protocol and domain are separated by the first occurrence of :// token, while domain and path are separated by the first occurrence of / which come after :// token.
 URL string can looks like this:
###[protocol://][domain[/[path]]]
 where any thing between [] is optional.
 
###Notice that:
 Protocol Domain and Path can have any character combinations. if this is not valid, then rules can be later on enforced using regular expressions.

## Run
### using maven
 mvn package
 mvn exec:java
