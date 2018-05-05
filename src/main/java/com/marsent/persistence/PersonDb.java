/*
 * (c) Copyright 2018 Yiwei Gao. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.marsent.persistence;

import com.marsent.data.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class PersonDb {
    private static final Map<Integer, Person> PERSONS = new TreeMap<>();

    static {
        PERSONS.put(1, new Person(1, "FN1", "LN1", "email1@email.na"));
        PERSONS.put(2, new Person(2, "FN2", "LN2", "email2@email.na"));
        PERSONS.put(3, new Person(3, "FN3", "LN3", "email3@email.na"));
        PERSONS.put(4, new Person(4, "FN4", "LN4", "email4@email.na"));
    }

    private PersonDb() {
        // Intentionally blank.
    }

    public static Person getById(int id) {
        return PERSONS.get(id);
    }

    public static List<Person> getAll() {
        List<Person> result = new ArrayList<Person>();
        for (Integer key : PERSONS.keySet()) {
            result.add(PERSONS.get(key));
        }
        return result;
    }

    public static int getCount() {
        return PERSONS.size();
    }

    public static void remove() {
        if (!PERSONS.keySet().isEmpty()) {
            PERSONS.remove(PERSONS.keySet().toArray()[PERSONS.keySet().size() - 1]);
        }
    }

    public static String save(Person person) {
        String result = "";
        if (PERSONS.get(person.getId()) != null) {
            result = "Updated Person with id=" + person.getId();
        } else {
            result = "Added Person with id=" + person.getId();
        }
        PERSONS.put(person.getId(), person);
        return result;
    }
}
