print('Start #################################################################');

db = db.getSiblingDB('prog5');
db.createUser(
    {
        user: 'prog5',
        pwd: 'Password111',
        roles: [{role: 'readWrite', db: 'prog5'}],
    },
);

print('END #################################################################');