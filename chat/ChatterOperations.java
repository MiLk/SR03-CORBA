// **********************************************************************
//
// Generated by the ORBacus IDL to Java Translator
//
// Copyright (c) 2002
// IONA Technologies, Inc.
// Waltham, MA, USA
//
// All Rights Reserved
//
// **********************************************************************

// Version: 4.2.2

package chat;

//
// IDL:Chatter:1.0
//
/***/

public interface ChatterOperations
{
    //
    // IDL:Chatter/getTheDate:1.0
    //
    /***/

    String
    getTheDate();

    //
    // IDL:Chatter/receive:1.0
    //
    /***/

    void
    receive(String msg);
}
