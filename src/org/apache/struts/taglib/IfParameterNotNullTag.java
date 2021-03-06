/*
 * $Header: /home/cvs/jakarta-struts/src/share/org/apache/struts/taglib/IfParameterNotNullTag.java,v 1.3 2000/08/01 20:03:33 craigmcc Exp $
 * $Revision: 1.3 $
 * $Date: 2000/08/01 20:03:33 $
 *
 * ====================================================================
 *
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 1999 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Tomcat", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */


package org.apache.struts.taglib;


import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;


/**
 * Conditionally include the body of this tag if the specified parameter
 * is present in the current request, and has a length greather than zero.
 *
 * @author Craig R. McClanahan
 * @version $Revision: 1.3 $ $Date: 2000/08/01 20:03:33 $
 */

public class IfParameterNotNullTag extends TagSupport {


    // ----------------------------------------------------- Instance Variables


    /**
     * The name of the parameter being compared.
     */
    protected String name = null;


    // ------------------------------------------------------------- Properties


    /**
     * Return the parameter name.
     */
    public String getName() {

	return (this.name);

    }


    /**
     * Set the parameter name.
     *
     * @param name The new parameter name
     */
    public void setName(String name) {

	this.name = name;

    }


    // --------------------------------------------------------- Public Methods


    /**
     * Retrieve the specified parameter, and decide whether
     * or not to include the body content.
     *
     * @exception JspException if a JSP exception has occurred
     */
    public int doStartTag() throws JspException {

	// Retrieve the value of the specified parameter
	HttpServletRequest request =
	  (HttpServletRequest) pageContext.getRequest();
	String value = request.getParameter(name);

	// Conditionally evaluate the body of our tag
	if ((value != null) && (value.length() > 0))
	    return (EVAL_BODY_INCLUDE);
	else
	    return (SKIP_BODY);

    }



    /**
     * Release any acquired resources.
     */
    public void release() {

	super.release();
	name = null;

    }


}
