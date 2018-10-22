# Java Assessment - SmartShare

# Assessment Overview

For this assessment, you will be creating a file [command-line interface](https://en.wikipedia.org/wiki/Command-line_interface) application for 'securely' storing files. The application will be split into two parts - the client and the server. It will have support for concurrency using the Java library's concurrency API and will store files and related information in a relational database.

---

## Command-line applications

The client side of this application is a command-line application. Command-line applications, also refered to as console applications, are computer programs designed to be used from a text interface, such as a shell. Command-line applications usually accept various inputs as arguments, often referred to as parameters or sub-commands, as well as options, often referred to as flags or switches. Some popular and widely-used command-line applications include [grep](http://man7.org/linux/man-pages/man1/grep.1.html), [git](http://man7.org/linux/man-pages/man1/git.1.html), and [curl](https://curl.haxx.se/).

When creating any software that a user will be directly interacting with, it is important to make sure that the 'learning curve' is as smooth and as low as reasonably possible. Making things unique, over-complicated, or going against the grain of the majority of other applications is a great way to ensure that no one wants to use your software. This is especially important for command-line applications. The world of command-line applications is one with a lot of history, refinement, and standards. Because of this, it is important to follow convention and utilize (as much as possible) what is generally considered best-practices for building CLI applications.

Creating command-line applications is difficult. Parsing text, arguments, options, and providing feedback to the user are just a few of the things you need to consider when writing an easy-to-use command-line application. Like anything in programming, we don't want to re-invent the wheel. We will be using [**PicoCLI**](https://picocli.info/) for our client-side java CLI application. It provides an easy-to-use API with minimal boilerplate. Their documentation is fairly good and should be referenced FIRST for issues regarding the CLI portion of this assessment.

## Requirements Overview

#### Uploading
When the user wants to upload a file, they should be required to provide a ['relative path'](https://support.dtsearch.com/webhelp/dtsearch/relative_paths.htm) to the file. They have the option of providing their own password which will act as the 'key' or 'password' for people wishing to download the file. If they do not provide their own password, a password will be generated for them. This functionality is provided for you in the skeleton of the assessment.

**Additional features for uploading**
* **Expiration** - The client should be able to provide an [optional](https://picocli.info/#_options_and_parameters) flag denoting the number of minutes until the file expires and can no longer be accessed.
* **Maximum Downloads** - The client should be able to provide an [optional](https://picocli.info/#_options_and_parameters) flag denoting the maximum number of downloads available until the file can no longer be accessed

#### Downloading

When a user wants to retrieve a file, they will be required to provide a filename and a password. 

There are four cases in which the user should not be able to retrieve the specified file.
* The file doesn't exist
* The password doesn't match the password provided when the file was uploaded
* The file has 'expired' - the time has passed that was specified when the file was uploaded
* The maximum downloads have been reached - this value was passed when the file was uploaded

In all cases, the user should be displayed with *the same* error message.

#### Viewing

When a user wants to view a file's current 'status' (downloads remaining and time until expiration), they must provide the file name and a correct password. They should then be shown the remaining downloads and time until expiration.

---

## Provided Skeleton

**Disclaimer**:  *The skeleton provided is not thoroughly tested and may not be utilizing features of picocli that could make this easier. It is a working example showing **one** way to approach this problem. It is written to be enough scaffolding to build on top of as well as demonstrate how to use picocli. However, it is entirely up to you how the user will interact with the CLI as long as the requirements listed below are met.*  

The skeleton contains a basic boilerplate that utilizes declaritively registered [**subcommands**](https://picocli.info/#_subcommands). This enabled the ability to break uploading and download into separate parts of the application without using options. You are also given a `schema.sql` which you can use to generate the appropriate tables to be used when creating your 'Data Access Objects' classes.

The skeleton contains **very** basic scaffolding including a working command-line interface application that takes 'download' and 'upload' commands and prints verification messages to the user. It also contains empty DTO classes in the `client.dto` package, an incomplete `Api` class in the `api` package, and an empty `SmartShareServer` class in the `server` package. The skeleton does not contain any code that connects the client to the server The server side of the skeleton is left completely empty and it is up to you to create a concurrent server that interacts with a database in order to appropriately store and retrieve files. It also lacks any database connectivity code. You will be required to implement DAO's the do the required CRUD operations on the database generated from the provided schema. 

