Feature: As a new user I want to register
  so that I can enjoy the shopping

  @smoke
  Scenario: User wants to register his valid detail
    Given user is on home page
    When he enter his valid detail for registration
    Then he able to register successfully

  @smoke
  Scenario: User wants to login with his valid credential
    Given user is on home page
    When he nevigage to login page
    And provide valid login detai
    Then he is able to login successfully

  @smoke
  Scenario Outline: login with unregister detail
    Given user is on home page
    When he nevigage to login page
    And enter invalid "<Email>", "<Password>"
    Then he is not able to login successfully and receved Error "<Message>"
    Examples:
      | Email              | Password | Message                   |
      | ankesh97@gmail.com | 1234     | No customer account found |


  @smoke
  Scenario Outline: respective product list
    Given user is on home page
    When he looks product in "<productTab>"
    Then "<count>" categories  relating to  selected  should be displayed
    Examples:
      | productTab        | count |
      | Computers         | 3     |
      | Electronics       | 3     |
      | Apparel           | 3     |
      | Digital downloads | 0     |
#      | Books             | 0     |
#      | Jewelry           | 0     |
#      | Gift Cards        | 0     |

  @smoke
  Scenario Outline: product from eacth category
    Given user is on home page
    When he looks product in "<productTab>"
    And select the "<productCategory>" from "<productTab>"
    Then we can see the product "<count>"
    Examples:
      | productTab  | productCategory | count |
      | Computers   | Desktops        | 3     |
      | Computers   | Notebooks       | 6     |
      | Computers   | Software        | 3     |
      | Electronics | Camera & photo  | 3     |
#      | Electronics       | Cell phones       | 3     |
#      | Electronics       | Others            | 3     |
#      | Apparel           | Shoes             | 3     |
#      | Apparel           | Clothing          | 4     |
#      | Apparel           | Accessories       | 3     |
#      | Digital downloads | Digital downloads | 3     |
#      | Books             | Books             | 3     |
#      | Jewelry           | Jewelry           | 3     |
#      | Gift Cards        | Gift Cards        | 3     |

  @smoke
  Scenario Outline: select product from each category
    Given user is on home page
    When he looks product in "<productTab>"
    Then select the product from "<productCategory>" and add to the Cart
    Examples:
      | productTab  | productCategory |
      | Computers   | Desktops        |
      | Electronics | Others          |
      | Computers   | Notebooks       |
      | Computers   | Software        |

  @smoke
  Scenario Outline: Checkout and Order processing
    Given he enter his valid detail for registration
    When he able to register successfully
    And he nevigage to login page
    Then provide valid login detai
    And he is able to login successfully
    When he looks product in "<productTab>"
    And select the product from "<productCategory>" and add to the Cart
    Then update shopping Cart

    Examples:
      | productTab | productCategory |
      | Computers  | Desktops        |




