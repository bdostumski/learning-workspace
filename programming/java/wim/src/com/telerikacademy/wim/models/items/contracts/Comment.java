package com.telerikacademy.wim.models.items.contracts;

import java.io.Serializable;

public interface Comment extends Serializable {

    String getMessages();

    String getAuthor();

}
