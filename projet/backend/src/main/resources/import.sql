INSERT INTO USERS (email, lastname, firstname, nb_borrow, password) VALUES ('toto@f.c', 'toto', 'titi', 2, '$2a$10$8QSgK4CkeuYy1/sTJZ0H9uyz6grug9Bd/D0oJWDdV/ruT5Hw3e2Vu')
INSERT INTO USERS (email, lastname, firstname, nb_borrow, password) VALUES ('admin@a.a', 'admin', 'dmin', 2, '$2a$10$8QSgK4CkeuYy1/sTJZ0H9uyz6grug9Bd/D0oJWDdV/ruT5Hw3e2Vu')


INSERT INTO ITEM VALUES (1, 'metallica', '2022-10-07', '1991-08-13', 'Après le succès des éditions Super Deluxe de Kill’ Em All, Ride the Lightning, Master Of Puppets ...And Justice For All voici le très attendu Black Album. De mémoire de fans jamais le contenu d’une édition Super Deluxe n’a été aussi riche. Avec 6 vinyles, 14 CD, 5 DVD, un hardbook, un poster, et des pins. Le groupe a bien sûr remasterisé l’album, mais il a surtout plongé dans les archives pour nous offrir de nombreux enregistrements et captations vidéo, inédits à ce jour. Ces témoignages rendent compte de la vie du groupe en studio à l’époque de l’enregistrement de l’album, mais également de leur incroyable présence scénique à travers les live inédits.', 'CD-Metallica-Black.jpg', 1, 'black')
INSERT INTO CD VALUES (12, 1)

INSERT INTO ITEM VALUES (2, 'florent pagny', '2022-10-07', '2003-04-08', 'Ailleurs land est le 8e album studio de Florent Pagny et son 10e album discographique, sorti le 8 avril 2003 chez Mercury France, sous la direction artistique de Bertrand Lamblot. Enregistré en Patagonie (pour les voix) où Pagny a élu domicile, cet album est précédé d’une polémique à propos du premier single qui en est extrait : Ma liberté de penser. Son auteur, Lionel Florence y énumère tout ce que le fisc peut saisir, c est-à-dire tout, sauf sa liberté de penser. Néanmoins, la chanson est un succès immédiat.', 'CD-FlorentPagny-Ailleurs_Land.jpg', 2, 'ailleurs land')
INSERT INTO CD VALUES (11, 2)

INSERT INTO ITEM VALUES (3, 'ariana grande', '2022-09-10', '2020-10-30', 'Positions est le sixième album studio de la chanteuse américaine Ariana Grande, publié le 30 octobre 2020 par Republic Records2. Cet album fait suite à K Bye For Now (SWT Live), son dernier projet musical et Thank U, Next, son dernier album sorti en 2019.', 'CD-ArianaGrande-Positions.jpg', 3, 'positions')
INSERT INTO CD VALUES (14, 3)

INSERT INTO ITEM VALUES (4, 'black pink', '2022-09-13','2022-09-22', 'Born Pink est le deuxième album complet du girl group sud-coréen Blackpink, officiellement sorti le 16 septembre 2022 à 13 heures (heure coréenne) et produit par YG Entertainment. La sortie de l’album était accompagnée par celle du clip vidéo de la chanson principale, Shut Down.', 'CD-BlackPink-Born_Pink.jpg', 2, 'born pink' )
INSERT INTO CD VALUES (11, 4)


INSERT INTO ITEM VALUES (5, 'joe russo', '2022-10-07', '2019-08-30', 'Thanos ayant anéanti la moitié de l’univers, les Avengers restants resserrent les rangs dans ce vingt-deuxième film des Studios Marvel, grande conclusion d’un des chapitres de l’Univers Cinématographique Marvel.', 'DVD-Avengers_Endgame-Blu_ray.jpg', 3, 'avengers: endgame')
INSERT INTO DVD VALUES (181, 'Blu-ray', 5) 
 
INSERT INTO ITEM VALUES (6, 'roger allers', '2022-10-05', '2011-08-24', 'Sur les hautes terres d''Afrique règne Mufasa, lion tout-puissant respecté et admiré pour sa grande sagesse et sa générosité. Son jeune fils Simba insouciant et turbulent doit lui succéder un jour. Mais Scar, l''oncle jaloux du lionceau élabore un plan qui l''obligera à s''enfuir.', 'DVD-Le_Roi_Lion.jpg', 5, 'le roi Lion')
INSERT INTO DVD VALUES (84, 'Dvd', 6)

INSERT INTO ITEM VALUES (7, 'francis veber', '2022-10-12', '2011-08-24', 'Ruby n''a qu''une idée en tête : se venger de l’homme qui a assassiné la femme qu’il aimait.Quentin n’a en tête que très peu de neurones. Juste assez pour être d’une grande gentillesse et d’une bêtise à entrer dans le Livre des Records.', 'DVD-Tais_toi.jpg', 7, 'tais toi !')
INSERT INTO DVD VALUES (85, 'Dvd', 7)

INSERT INTO ITEM VALUES (8, 'steven spielberg', '2022-10-12', '2019-12-01', 'À quelques jours du début de la saison estivale, les habitants de la petite station balnéaire d’Amity sont mis en émoi par la découverte sur le littoral du corps atrocement mutilé d’une jeune vacancière.', 'DVD-Les_Dents_de_la_mer-Blu_Ray_4K.jpg', 2, 'les dents de la mer')
INSERT INTO DVD VALUES (123, 'Blu-ray 4K', 8)


INSERT INTO ITEM VALUES (9, 'stephen king', '2022-08-10', '2019-09-04', 'Un phénomène inexplicable touche les femmes sur toute la planète : une sorte de cocon les enveloppe durant leur sommeil, et si l’on tente de les réveiller, on prend le risque de les transformer en véritables furies. Bientôt, presque toutes sont touchées par la fièvre Aurora, et le monde est livré à la violence masculine. À Dooling, petite ville des Appalaches, la mystérieuse Evie semble immunisée contre cette épidémie. Cas d’étude pour la science ou créature démoniaque, échappera-t-elle à la fureur des hommes privés soudainement de femmes ?', 'BOOK-Sleeping_Beauties.jpg', 3, 'sleeping beauties')
INSERT INTO BOOK VALUES (2226400222l, 9)

INSERT INTO ITEM VALUES (10, 'christian jacq', '2022-02-08', '2022-10-19', 'Issu de plus d''un demi-siècle de recherches, cet ouvrage, illustré de documents remarquables, dont beaucoup rares et peu connus, tente de comprendre comment L''Égypte pharaonique a façonné l''âme du monde et accompli l''impossible mariage entre l''esprit et la matière. Avec son incroyable talent de narrateur, Christian Jacq redonne vie à cet univers qui parle à tous les êtres et continue, à travers les siècles, à transmettre des valeurs fondamentales, sans lesquelles une société cède au chaos et à la violence.  Un passionnant voyage dans le temps pour découvrir les clés de cette civilisation de lumière : l''univers spirituel (dieux et les divinités), la politique (fonctionnement de l''état pharaonique), l''économie, la vie quotidienne et sa sacralisation.', 'BOOK-L_Egypte_pharaonique.jpg', 2, 'l''égypte pharaonique')
INSERT INTO BOOK VALUES (2376713358l, 10)

INSERT INTO ITEM VALUES (11, 'robert c. martin', '2022-09-28', '2019-04-05', 'Le point sur les pratiques pour nettoyer un code. Après une description des principes, des motifs et des pratiques employés dans l’écriture d un code propre, des études de cas présentent différents exercices de nettoyage.', 'BOOK-Coder_proprement.jpg', 2, 'coder proprement')
INSERT INTO BOOK VALUES ( 232600227l, 11)

INSERT INTO ITEM VALUES (12, 'j.k. rowling', '2022-10-12', '2017-10-10', 'Lorsqu''il n''était encore qu''un bébé, les parents de Harry Potter furent tués par un sorcier puissant. Ayant miraculeusement survécu à cette attaque, Harry n''en n''a gardé qu''une cicatrice sur le front et a été adopté par sa tante et son horrible famille.', 'BOOK-Harry_Potter_a_lecole_des_sorciers.jpg', 5, 'harry potter à l''école des sorciers')
INSERT INTO BOOK VALUES ( 2075145938l, 12)

INSERT INTO BORROW (date_Return, date_Take, quantity, USERS_ID ) VALUES ('2022-10-12', '2022-10-10', 0, 1)
INSERT INTO BORROW_ITEM VALUES (1,1)

INSERT INTO BORROW (date_Return, date_Take, quantity, USERS_ID  ) VALUES ( null, '2022-10-10', 2, 1)
INSERT INTO BORROW_ITEM VALUES (2,2)
