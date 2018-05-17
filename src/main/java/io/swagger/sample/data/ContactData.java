/**
 *  Copyright 2016 SmartBear Software
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.swagger.sample.data;

import io.swagger.sample.models.Category;
import io.swagger.sample.models.Contact;
import java.util.*;

public class ContactData {

    static List<Contact> contacts = new ArrayList<Contact>();
    static List<Category> categories = new ArrayList<Category>();

    public static Contact getContactById(long contactId) {
        for (Contact contact : contacts) {
            if (contact.getId() == contactId) {
                return contact;
            }
        }
        return null;
    }

    public static boolean deleteContact(long contactId) {
        if (contacts.size() > 0) {
            for (int i = contacts.size() - 1; i >= 0; i--) {
                Contact contact = contacts.get(i);
                if (contact.getId() == contactId) {
                    contacts.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public static void deleteAllContacts() {
        if (contacts.size() > 0) {
            for (int i = contacts.size() - 1; i >= 0; i--) {
                contacts.remove(i);
            }
        }
    }

//    public static List<Contact> findContactByStatus(String status) {
//        List<Contact> result = new java.util.ArrayList<Contact>();
//        if (status == null) {
//            return result;
//        }
//        String[] statuses = status.split(",");
//        for (Contact contact : contacts) {
//            for (String s : statuses) {
//                if (s.equals(contact.getStatus())) {
//                    result.add(contact);
//                }
//            }
//        }
//        return result;
//    }
    public static List<Contact> getAllContacts() {
        return contacts;
    }

//    public static List<Contact> findContactByTags(String tags) {
//        List<Contact> result = new java.util.ArrayList<Contact>();
//
//        if (tags == null) {
//            return result;
//        }
//        String[] tagList = tags.split(",");
//        for (Contact contact : contacts) {
//            if (null != contact.getTags()) {
//                for (Tag tag : contact.getTags()) {
//                    for (String tagListString : tagList) {
//                        if (tagListString.equals(tag.getName())) {
//                            result.add(contact);
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }
    public static Contact addContact(Contact contact) {
        if (contact.getId() == 0) {
            long maxId = 0;
            for (int i = contacts.size() - 1; i >= 0; i--) {
                if (contacts.get(i).getId() > maxId) {
                    maxId = contacts.get(i).getId();
                }
            }
            contact.setId(maxId + 1);
        }
        if (contacts.size() > 0) {
            for (int i = contacts.size() - 1; i >= 0; i--) {
                if (contacts.get(i).getId() == contact.getId()) {
                    contacts.remove(i);
                }
            }
        }
        contacts.add(contact);
        return contact;
    }

//    public static Map<String, Integer> getInventoryByStatus() {
//        Map<String, Integer> output = new HashMap<String, Integer>();
//        for (Contact contact : contacts) {
//            String status = contact.getStatus();
//            if (status != null && !"".equals(status)) {
//                Integer count = output.get(status);
//                if (count == null) {
//                    count = new Integer(1);
//                } else {
//                    count = count.intValue() + 1;
//                }
//                output.put(status, count);
//            }
//        }
//        return output;
//    }
//
//    private static Contact createContact(long id, Category cat, String name, String[] urls,
//        String[] tags, String status) {
//        Contact contact = new Contact();
//        contact.setId(id);
//        contact.setCategory(cat);
//        contact.setName(name);
//        if (null != urls) {
//            List<String> urlObjs = new ArrayList<String>();
//            for (String urlString : urls) {
//                urlObjs.add(urlString);
//            }
//            contact.setPhotoUrls(urlObjs);
//        }
//        List<Tag> tagObjs = new java.util.ArrayList<Tag>();
//        int i = 0;
//        if (null != tags) {
//            for (String tagString : tags) {
//                i = i + 1;
//                Tag tag = new Tag();
//                tag.setId(i);
//                tag.setName(tagString);
//                tagObjs.add(tag);
//            }
//        }
//        contact.setTags(tagObjs);
//        contact.setStatus(status);
//        return contact;
//    }
//
//    private static Category createCategory(long id, String name) {
//        Category category = new Category();
//        category.setId(id);
//        category.setName(name);
//        return category;
//    }
}
