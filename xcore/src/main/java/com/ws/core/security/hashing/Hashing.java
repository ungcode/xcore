package com.ws.core.security.hashing;

import java.util.function.Function;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Based on BCrypt that implements OpenBSD-style Blowfish password hashing using
 * the scheme described in "A Future-Adaptable Password Scheme" by Niels Provos
 * and David Mazieres. This password hashing tries to thwart off-line password
 * cracking using a computationally-intensive hashing algorithm, based on Bruce
 * Schneier's Blowfish cipher.
 */

public class Hashing {

    private final int cost;
		private final String salt;


		/**
		 * @param cost log2(Iterations). e.g. 12 ==> 212 = 4,096 iterations
		 * @param salt the salt to hash
		 */

		public Hashing(int cost, String salt)
		{
        this.cost = cost;
				this.salt = salt;
    }

		public Hashing()
		{
			this.cost = 0;
			this.salt = null;
		}

		/**
		 * Hash a password using the OpenBSD bcrypt scheme
		 * 
		 * @param password the password to hash
		 * @return the hashed password
		 */
		public String doHash(String password)
		{
			return BCrypt.hashpw(password, salt);
    }

		/**
		 * Check that a plain text password matches a previously hashed one
		 * 
		 * @param password the plain text password to verify
		 * @param hashed   the previously-hashed password
		 * @return true if the passwords match, false otherwise
		 */
		public boolean verifyHash(String password, String hashed)
		{
			return BCrypt.checkpw(password, hashed);
    }


		/**
		 * It might be smart to only allow increasing the cost, maybe one a year and
		 * update the hashed value
		 * 
		 * @param password   plain text supplied password
		 * @param hash       hashed value
		 * @param updateFunc a function to update the hashed value
		 * @return true or false if success or failure
		 */
		public boolean verifyAndUpdateHash(String password, String hash, Function<String, Boolean> updateFunc)
		{
			if ( BCrypt.checkpw(password, hash))
			{
            int cost = getCost(hash);
						// It might be smart to only allow increasing the cost.
            // If someone makes a mistake the ability to undo it would be nice though.
            if (cost != this.cost) {

                String newHash = doHash(password);
                return updateFunc.apply(newHash);
            }
            return true;
        }
        return false;
    }

		/**
		 * Derived from bcrypt internals to get the stored cost
		 * 
		 * @param hash hashed value
		 * @return cost of computation
		 */
		private int getCost(String hash)
		{
        char minor = (char)0;
        int off = 0;

        if (hash.charAt(0) != '$' || hash.charAt(1) != '2')
            throw new IllegalArgumentException ("Invalid salt version");
        if (hash.charAt(2) == '$')
            off = 3;
        else {
            minor = hash.charAt(2);
            if (minor != 'a' || hash.charAt(3) != '$')
                throw new IllegalArgumentException ("Invalid salt revision");
            off = 4;
        }

				// Extract number of cost
        if (hash.charAt(off + 2) > '$')
            throw new IllegalArgumentException ("Missing salt rounds");
        return Integer.parseInt(hash.substring(off, off + 2));
    }

}

