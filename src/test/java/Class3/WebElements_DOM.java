package Class3;

public class WebElements_DOM {
    /**
     * DOM -> Document Object Model
     *
     * Front End code -> generates DOM -> DOM creates the website
     *
     * DOM is always a html document.
     *
     * <html>
     *      <head></head>
     *      <body></body>
     * </html>
     *
     *
     *
     * <tag1>  -> starting of tag1 (Note: tag-names CANNOT have spaces)
     *
     * </tag1>  -> closing of tag1
     *
     * eg: html, head, body, script, div, form, input, span
     */
    /**
     * Tags, attributes and attribute's-value
     *
     * <tag1 attr1="val1" attr2 attr3="val11" attr4="val111">
     *     attr1, attr2, attr3, attr4 --> attributes of tag1
     *          (Note: attribute-names CANNOT have spaces)
     *          (Note: attribute may or mayNOT have a value)
     *
     *     attr1 has value = val1
     *     attr2 has value = null
     *     attr3 has value = val11
     *     attr4 has value = val111
     *
     * eg:
     * <input type="hidden" autocomplete="off" name="login_source" value="comet_headerless_login">
     *      type, autocomplete, name, value are attributes of input-tag
     *
     *
     *
     *  <tag1 attr1="val1" attr2 attr3="val11" attr4="val111">Test Value</tag1>
     *      "Test Value" is the text of tag1
     *
     * <button value="1" class="_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy" name="login" data-testid="royal_login_button" type="submit" id="u_0_d_MA">Log In</button>
     *      --> button tag has text value = "Log In"
     *
     *
     * <img class="fb_logo _8ilh img" src="https://static.xx.fbcdn.net/rsrc.php/y8/r/dF5SId3UHWd.svg" alt="Facebook">
     *     --> img-tag has No text value
     *
     * <tag1 attr11="val1" attr12="val2" attr13>
     *     <tag2 attr21="val21" attr22="val22">
     *         text value
     *     </tag2>
     *     <tag3>
     *         text value again
     *     </tag3>
     *      text data
     * </tag1>
     *
     *
     * text with tag1 = text data
     * text with tag2 = text value
     * text with tag3 = text value again
     *
     */
    /**
     * Verify button text on login button is Log In
     * 1. Open browser
     * 2. Launch facebook.com
     * 3. Verify the text of login button is "Log In"
     * 4. Close the browser
     *
     * Verify the text of login button is "Log In"
     * String expectedText = "Log In"
     * String actualText = get the Text of button-tag
     * Assert.assertEquals(actualText, expectedText, "");
     *
     *
     *
     * Verify text on login email pr phone number field is "Email or phone number"
     * 1. Open browser
     * 2. Launch facebook.com
     * 3. Verify text on login email pr phone number field is "Email or phone number"
     * 4. Close the browser
     *
     * Verify text on login email pr phone number field is "Email or phone number"
     *      String expectedText = "Email or phone number"
     *      String actualText = get the value of placeholder-attribute
     *      Assert.assertEquals(actualText, expectedText, "");
     *
     */

    /**
     * <tag1 attr1="value1" attr2="value2" attr3="value3" attr4="value4">
     *     <tag2 id="abcd" data-text-id="unique data" attr3="value3" attr4="value4">
     *         <tag3>Not Unique Text
     *              <subTag attr1="value1" attr2="value2" attr3="value3" attr4="value4">Unique Text</subTag>
     *         </tag3>
     *         <tag11 attr1="value1" attr2="value2" attr3="value3" attr4="value4">Unique Text</tag11>
     *         <tag21 attr1="value1" attr2="value2" attr3="value3" attr4="value4">Unique Text</tag21>
     *     </tag2>
     *     <tag4 attr1="value1" attr2="value2" attr3="value3" attr4="value4">
     *         <a attr1="value1" attr2="value2">Unique Text</tag>
     *     </tag4>
     *     <tag6 attr1="value1" attr2="value2" attr3="value3" attr4="value4">
     *          <tag7 attr1="value1" attr2="value2" attr3="value3" attr4="value4"></tag>
     *     </tag6>
     * </tag1>
     *
     *
     * children of tag1 --> tag2, tag4, tag6    (therefore, tag2, tag4, tag6 are siblings)
     * children of tag3 --> subTag
     *
     * sibling of a-tag --> None
     * sibling of tag11 --> tag3 and tag21
     *
     * following-sibling (sibling-tags which appearing in the dom after the tag)
     * following-sibling of tag11 --> tag21
     * following-sibling of tag3 --> tag11, tag21
     *
     * preceding-sibling (sibling-tags appearing in the dom before the tag)
     * preceding-sibling of tag11 --> tag3
     * preceding-sibling of tag3 --> 0
     *
     * following (tags in the dom appearing after the tag)
     * following of tag3 --> subTag, tag11, tag21, tag4, a, tag6, tag7
     * following of tag6 --> tag7
     *
     * preceding (tags in the dom appearing before the tag)
     * preceding of tag3 --> tag2, tag1
     * preceding of tag6 --> a, tag4, tag21, tag11, subTag, tag3, tag2, tag1
     * preceding of tag11 --> subTag, tag3, tag2, tag1
     *
     * descendant (tags in the family chain appearing in the dom after the tag)
     * descendant of tag3 --> subTag
     * descendant of tag2 --> tag3, subTag, tag11, tag21
     * descendant of a --> 0
     *
     * ancestor (tags in the family chain appearing in the dom after the tag)
     * ancestor of tag6 --> tag1
     * ancestor of tag11 --> tag2, tag1
     *
     *
     * <tag1 attr1="value1" attr2="value2" attr3="value3" attr4="value4">
     *     <tag2 id="abcd" data-text-id="unique data" attr3="value3" attr4="value4">
     *         <tag3>Not Unique Text
     *              <subTag attr1="value1" attr2="value2" attr3="value3" attr4="value4">Unique Text</subTag>
     *         </tag3>
     *         <tag11 attr1="value1" attr2="value2" attr3="value3" attr4="value4">Unique Text</tag11>
     *         <tag21 attr1="value1" attr2="value2" attr3="value3" attr4="value4">Unique Text</tag21>
     *     </tag2>
     *     <tag4 attr1="value1" attr2="value2" attr3="value3" attr4="value4">
     *         <a attr1="value1" attr2="value2">Unique Text</tag>
     *     </tag4>
     *     <tag6 attr1="value1" attr2="value2" attr3="value3" attr4="value4">
     *          <tag7 attr1="value1" attr2="value2" attr3="value3" attr4="value4"></tag>
     *     </tag6>
     * </tag1>
     *
     * what is the text of tag3? -> Not Unique Text
     * how many attributes with tag3? -> 0
     *
     * <tag1 attr11="val1" attr12="val2" attr13>
     *     <tag2 attr21="val21" attr22="val22">
     *         text value
     *     </tag2>
     *     <tag3>
     *         text value again
     *     </tag3>
     *      text data
     * </tag1>
     *
     *
     * what is the value of attribute(attr13) with tag1 -> null
     */
}
