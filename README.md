# Prerequisite

Before we can start building the application, we need to have an OpenShift free account and client tools installed.

# Step 1: Create DIY application

To create an application using client tools, type the following command:

    rhc app create backend diy-0.1

This command creates an application *backend* using *DIY* cartridge and clones the repository to *backend* directory.

# Step 2: Add MYSQL cartridge to application

The application we are creating will use MYSQL database, hence we need to add appropriate cartridge to the application:

	rhc cartridge add mysql-5.5 -a backend

After creating the cartridge, it is possible to check its status with the following command:

    rhc cartridge status mysql-5.5 --app backend

# Step 3: Delete Template Application Source code

OpenShift creates a template project that can be freely removed:

    git rm -rf .openshift README.md diy misc

Commit the changes:

    git commit -am "Removed template application source code"

# Step 4: Pull Source code from GitHub or Local machine repository

    git remote add upstream https://github.com/Java-SpringBoot/openshift-springboot-mysql-diy.git
    git pull -s recursive -X theirs upstream master --allow-unrelated-histories
   # Or
    git clone <git_url> <directory to create>
    git add .
    git commit -m "A checkin to my application"
    # Start Script :
     git update-index --chmod=+x .openshift/action_hooks/deploy
     git commit -m "A checkin to my application"
    
# Step 5: Push changes

The basic template is ready to be pushed:

	git push

The initial deployment (build and application startup) will take some time (up to several minutes). Subsequent deployments are a bit faster, although starting Spring Boot application may take even more than 2 minutes on small Gear:

	Tomcat started on port(s): 8080/http
	Started Application in 125.511 seconds

You can now browse to: http://backend-<namespace>.rhcloud.com/manage/health and you should see:

	{
		"status": "UP",
		"database": "MYSQL",
		"hello": 1
	}

You can then browse to "/" to see the API root resource.

