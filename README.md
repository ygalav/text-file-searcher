# text-file-searcher

1. No tests, sad but had no time
2. Implementation with the focus of flexible design but sill Searcher is bad, 
Index and Chunk knows more about each other, Searcher should NOT know internals of 
Index which needs to be abstracted

What's Good:
1. Good enough level of decoupling
2. Almost zero efforts to make Parallel Indexer of Worker
3. Theoretically index Internals are not important for us
4. By using Repositories and Sources we can index MANY different sources at once 
and this will work well. So for example othe same index can contain local file from couple directories, 
from FTP and GoogleDrive 

To run
0. Use java 13
1 Build jak with mvn clean package (or use the one i commit)
2. Run via java -jar test-file-searcher-1.0-SNAPSHOT.jar
