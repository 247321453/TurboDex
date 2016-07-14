#include "FastLoadDex.h"
#include "HookCore.h"
#include<fcntl.h>
#define DEX2OAT_BIN "/system/bin/dex2oat"

#define DEBUG 1

static bool hooked = false;
static bool enable = false;

int (*org_execv)(const char *name, char **argv);
int (*org_open)(const char* path, int mode);

int my_execv(const char *name, char **argv) {
		#ifdef DEBUG
		LOGD("#execv %s.", name);
		#endif

		if(enable && strcmp(name, DEX2OAT_BIN) == 0) {
		//	exit(0);
		}
		
  		return org_execv(name, argv);
}

int my_open(const char* path, int mode){
	if(enable && strcmp(path, "/data/data/com.wadahana.testhook/a.txt") == 0) {
		path = "/data/data/com.wadahana.testhook/b.txt";
	}
		
  	return org_open(path, mode);
}

void enableFastLoadDex() {
	if(!hooked) {
		HOOK(execv);
		HOOK(open);
		hooked = true;
	}
	enable = true;
}

void closeFastLoadDex() {
	char temp[]="hello,abc!";

	int fd = 0;

	char pathname[255];

	if((fd=open("/data/data/com.wadahana.testhook/a.txt",O_WRONLY|O_CREAT,0640))==-1)

	{
		
	}else{

		int len=strlen(temp)+1;

		write(fd,temp,len);

		close(fd);
	}
	enable = false;
}