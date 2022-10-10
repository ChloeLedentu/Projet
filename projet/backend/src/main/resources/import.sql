
INSERT INTO MEMBER VALUES(1,'daniel@gmail.com', 'daniel', 'Jean', 0, 'psw')
INSERT INTO MEMBER VALUES(2, 'admin@gmail.com', 'admin', 'ad', 0, 'pswadmin')
INSERT INTO MEMBER VALUES(3,'bob@gmail.com', 'bob', 'Dupend', 0, 'psw')
INSERT INTO MEMBER VALUES(4,'kael@gmail.com', 'kael', 'Dumont', 0, 'psw')

INSERT INTO ITEM VALUES (1, 'Metallica', '2022-10-07', '1991-08-13', 'Après le succès des éditions Super Deluxe de Kill’ Em All, Ride the Lightning, Master Of Puppets ...And Justice For All voici le très attendu Black Album. \n De mémoire de fans jamais le contenu d’une édition Super Deluxe n’a été aussi riche. Avec 6 vinyles, 14 CD, 5 DVD, un hardbook, un poster, et des pins. Le groupe a bien sûr remasterisé l’album, mais il a surtout plongé dans les archives pour nous offrir de nombreux enregistrements et captations vidéo, inédits à ce jour. \n Ces témoignages rendent compte de la vie du groupe en studio à l’époque de l’enregistrement de l’album, mais également de leur incroyable présence scénique à travers les live inédits.', null, 4, 'Black')
INSERT INTO CD VALUES (12, 1)

INSERT INTO ITEM VALUES (2, 'Florent Pagny', '2022-10-07', '2003-04-08', 'Ailleurs land est le 8e album studio de Florent Pagny et son 10e album discographique, sorti le 8 avril 2003 chez Mercury France, sous la direction artistique de Bertrand Lamblot. \n Enregistré en Patagonie (pour les voix) où Pagny a élu domicile, cet album est précédé d une polémique à propos du premier single qui en est extrait : Ma liberté de penser. Son auteur, Lionel Florence y énumère tout ce que le fisc peut saisir, c est-à-dire tout, sauf sa liberté de penser. Néanmoins, la chanson est un succès immédiat.', null, 6, 'Ailleurs land')
INSERT INTO CD VALUES (11, 2)

INSERT INTO ITEM VALUES (3, 'Joe Russo', '2022-10-07', '2019-08-30', 'Thanos ayant anéanti la moitié de l’univers, les Avengers restants resserrent les rangs dans ce vingt-deuxième film des Studios Marvel, grande conclusion d’un des chapitres de l’Univers Cinématographique Marvel.', null, 3, 'Avengers: Endgame')
INSERT INTO DVD VALUES (181, 'Blu-ray', 3) 
 
INSERT INTO ITEM VALUES (4, 'Roger Allers', '2022-10-05', '2011-08-24', 'Sur les hautes terres d Afrique règne Mufasa, lion tout-puissant respecté et admiré pour sa grande sagesse et sa générosité. Son jeune fils Simba insouciant et turbulent doit lui succéder un jour. \n Mais Scar, l oncle jaloux du lionceau élabore un plan qui l obligera à s enfuir.', null, 5, 'Le roi Lion')
INSERT INTO DVD VALUES (84, 'Dvd', 4)

INSERT INTO ITEM VALUES (5, 'Stephen King', '2022-08-10', '2019-09-04', 'Un phénomène inexplicable touche les femmes sur toute la planète : une sorte de cocon les enveloppe durant leur sommeil, et si l on tente de les réveiller, on prend le risque de les transformer en véritables furies. Bientôt, presque toutes sont touchées par la fièvre Aurora, et le monde est livré à la violence masculine. \n À Dooling, petite ville des Appalaches, la mystérieuse Evie semble immunisée contre cette épidémie. Cas d étude pour la science ou créature démoniaque, échappera-t-elle à la fureur des hommes privés soudainement de femmes ?', null, 3, 'Sleeping Beauties')
INSERT INTO BOOK VALUES (2226400222l, 5)

INSERT INTO ITEM VALUES (6, 'Christian Jacq', '2022-02-08', '2022-10-19', 'Issu de plus d un demi-siècle de recherches, cet ouvrage, illustré de documents remarquables, dont beaucoup rares et peu connus, tente de comprendre comment L Égypte pharaonique a façonné l âme du monde et accompli l impossible mariage entre l esprit et la matière. \n Avec son incroyable talent de narrateur, Christian Jacq redonne vie à cet univers qui parle à tous les êtres et continue, à travers les siècles, à  transmettre des valeurs fondamentales, sans lesquelles une société cède au chaos et à la violence. \n  Un passionnant voyage dans le temps pour découvrir les clés de cette civilisation de lumière : l univers spirituel (dieux et les divinités), la politique (fonctionnement de l état pharaonique), l économie, la vie quotidienne et sa sacralisation.', null, 2, 'L Égypte pharaonique')
INSERT INTO BOOK VALUES (2376713358l, 6)

INSERT INTO BORROW VALUES (1, '2022-10-08', '2022-10-01', 1, 1)
INSERT INTO BORROW_ITEM VALUES (1,1)

INSERT INTO BORROW VALUES (2, '2022-10-08', '2022-10-01', 2, 1)
INSERT INTO BORROW_ITEM VALUES (1,2)