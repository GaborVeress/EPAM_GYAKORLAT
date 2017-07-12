Feature: Important usecase
  Scenario: Write a post after a successful login
    Given the user is on the https://wordpress.com/ webpage
    And the user navigates to the login page by clicking the Log In button
    When the user enters valid credentials
    Then the user should be on the Home page
    #(assert: url should be: https://blogforautotests.wordpress.com/)
    When the user clicks the write button
    Then the add a new post page should be loaded
    #(assert: page title should contain "new Post")
    And the user sets a title
    And the user sets a body
    And punlishes the post
    Then the user navigates to the https://wordpress.com/ and the recently created blog post should be visible
    #(assert)

  Scenario: Delete the recentlycreated blogpost
    Given the user is on the https://wordpress.com/ webpage
    And the user navigates to the login page by clicking the Log In button
    When the user enters valid credentials
    Then the user should be on the Home page
    #(assert: url should be: https://blogforautotests.wordpress.com/)
    And clicks the title of the recently created blogpost
    Then the user should be redirected to the blogpost wied page
    #(assert: url contains the title)
    And the user clicks on the edit button
    And deletes the post by clicking on the Move to trash button
    And navigates to the https://blogforautotests.wordpress.com/ page
    Then the post should be deleted
    #(assert)