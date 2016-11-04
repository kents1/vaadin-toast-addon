# Toastr Addon for Vaadin
**Toastr Addon for Vaadin** is a Vaadin server side component for the toastr JavaScript library.

## Current Version
Vaadin Toastr Addon: 1.0.0
Toastr: 2.1.3
JQuery: 2.1.4

## Install

- Install from Vaadin Directory ( https://vaadin.com/directory#!addon/toastr-vaadin )

## Running the demo

- Clone this repository ( https://github.com/kents1/vaadin-toast-addon.git )
- mvn clean install
- cd vaadin-toastr-demo
- mvn spring-boot:run

Go to http://localhost:8080/ to view the demo.

## Authors
**Simon Kent**

+ [http://twitter.com/kents1](http://twitter.com/kents1)

## Credits
All of the hard work has been performed here https://github.com/CodeSeven/toastr

## Notes

Perform a release

mvn release:prepare
mvn release:perform -Darguments="-Dmaven.deploy.skip=true"