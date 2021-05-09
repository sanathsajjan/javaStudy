package com.java.practice.string;

/**
 * String pool is possible only because String is immutable in Java. This way
 * Java Runtime saves a lot of heap space because different String variables can
 * refer to the same String variable in the pool. If String would not have been
 * immutable, then String interning would not have been possible because if any
 * variable would have changed the value, it would have been reflected in the
 * other variables too. If String is not immutable then it would cause a severe
 * security threat to the application. For example, database username, password
 * are passed as String to get database connection and in socket programming
 * host and port details passed as String. Since String is immutable, its value
 * can&#xFFFD;t be changed otherwise any hacker could change the referenced value to
 * cause security issues in the application. Since String is immutable, it is
 * safe for multithreading. A single String instance can be shared across
 * different threads. This avoids the use of synchronization for thread safety.
 * Strings are implicitly thread-safe. Strings are used in java classloader and
 * immutability provides security that correct class is getting loaded by
 * Classloader. For example, think of an instance where you are trying to load
 * java.sql.Connection class but the referenced value is changed to
 * myhacked.Connection class that can do unwanted things to your database. Since
 * String is immutable, its hashcode is cached at the time of creation and it
 * doesn&#xFFFD;t need to be calculated again. This makes it a great candidate for the
 * key in a Map and its processing is faster than other HashMap key objects.
 * This is why String is the most widely used as HashMap keys.
 *
 * Why to use char[] array over a string for storing passwords in Java? Strings
 * are immutable: Strings are immutable in Java and therefore if a password is
 * stored as plain text it will be available in memory until Garbage collector
 * clears it and as Strings are used in String pool for re-usability there are
 * high chances that it will remain in memory for long duration, which is a
 * security threat. Strings are immutable and there is no way that the content
 * of Strings can be changed because any change will produce new String. With an
 * array, the data can be wiped explicitly data after its work is complete. The
 * array can be overwritten and and the password won&#xFFFD;t be present anywhere in
 * the system, even before garbage collection. Security: Any one who has access
 * to memory dump can find the password in clear text and that&#xFFFD;s another reason
 * to use encrypted password than plain text. So Storing password in character
 * array clearly mitigates security risk of stealing password.
 *
 */
public class ImmutableString {

}
