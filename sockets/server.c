#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdlib.h>
#include <stdio.h>
#include <errno.h>
#include <string.h>
#include <sys/types.h>
#include <time.h>

int main(int argc, char *argv[])
{
 int listenfd=0, connfd=0;
 struct sockaddr_in serv_addr;
 
 char buffer[1025];
 time_t ticks;

  listenfd=socket(AF_INET, SOCK_STREAM,0);
  memset(&serv_addr,'0',sizeof(serv_addr));
  memset(buffer,'0',sizeof(buffer));

  serv_addr.sin_family=AF_INET;
  serv_addr.sin_addr.s_addr=htonl(INADDR_ANY);
  serv_addr.sin_port=htons(atoi(argv[1]));

  bind(listenfd,(struct sockaddr*)&serv_addr, sizeof(serv_addr));
  
  listen(listenfd,10);


while(1)
{
 connfd= accept(listenfd, (struct sockaddr*)NULL, NULL);
 ticks=time(NULL);

 snprintf(buffer, sizeof(buffer),"%.24s\r\n",ctime(&ticks));

 write(connfd,buffer, strlen(buffer));
 close(connfd);
 sleep(1);
 



}
return 0;
}
