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
// IDL:ChatService:1.0
//
/***/

public interface ChatServiceOperations
{
    //
    // IDL:ChatService/getTheDate:1.0
    //
    /***/

    String
    getTheDate();

    //
    // IDL:ChatService/newChatRoom:1.0
    //
    /***/

    void
    newChatRoom(String chatroom);

    //
    // IDL:ChatService/send:1.0
    //
    /***/

    void
    send(String chatroom,
         String msg);
}
