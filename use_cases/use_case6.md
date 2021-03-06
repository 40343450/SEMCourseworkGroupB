# USE CASE 
# Produce a Report of the top N populated countries in a region where N is provided by the user.

## Goal

As a user I want to produce a report of the top N populated countries in a region where N is provided by the user

## Scope

Company.

## Level

Primary task.

## Preconditions

The database contains the information about the regions their countries and their populations

## Success End Condition

A report of the top N populated countries in a region where N is provided by the user is available for user to view.

## Failed End Condition

No report of the top N populated countries in a region where N is provided by the user is produced.

## Primary Actor

User.

## Trigger

The organisation needs this report to be available to users

## Main Success Scenario

>- User inputs N
>- Report is created
>- Report details population of countries in a region with count equal to N organised by largest population to smallest
>- Report is available to users

## Extensions

>- Country does not exist:
>- User is notified

## Sub-variations

None.

## SCHEDULE

DUE DATE: Release 1.0