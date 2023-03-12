#https://geoscape.com.au/wp-content/uploads/2021/07/Geoscape-LGA-Localities-Wards-Design-Concepts.pdf
import pandas as pd
import mysql.connector
from mysql.connector import errorcode

DB_NAME = 'plastic'

TABLES = {}

TABLES['lga'] = (
    """
    CREATE TABLE IF NOT EXISTS lga (
      lga_pid varchar(15) NOT NULL,
      lga_name varchar(255) NOT NULL,
      recycle_bin varchar(50)  NOT NULL,	
      rubbish_bin varchar(50)  NOT NULL,
      PRIMARY KEY (lga_pid)
    ) ENGINE=InnoDB    
    """
    )

TABLES['product'] = (
    """
    CREATE TABLE IF NOT EXISTS product (
      product_id int NOT NULL,
      product varchar(255) NOT NULL,
      image varchar(50) NOT NULL,
      image_small  varchar(50) NOT NULL,
      is_accepted_default int NOT NULL,
      PRIMARY KEY (product_id)
    ) ENGINE=InnoDB
    """
    )    

TABLES['lga_product'] = (
    """
    CREATE TABLE IF NOT EXISTS lga_product (
      lga_pid varchar(15) NOT NULL,        
      product_id int NOT NULL,
      is_accepted int NOT NULL,
      PRIMARY KEY (lga_pid,product_id)
    ) ENGINE=InnoDB
    """
    ) 

TABLES['bin'] = (
    """
    CREATE TABLE IF NOT EXISTS bin (
      bin varchar(15) NOT NULL,        
      bin_image varchar(15) NOT NULL,        
      PRIMARY KEY (bin)
    ) ENGINE=InnoDB
    """
    )     

TABLES['product_point'] = (
    """
    CREATE TABLE IF NOT EXISTS product_point (
      product_id int NOT NULL,        
      point_type varchar(15) NOT NULL,        
      sequence int NOT NULL, 
      product_point varchar(255) NOT NULL        
    ) ENGINE=InnoDB
    """
    )     
        			



table_sources = [
         ['lga','lga.csv']
        ,['product','product.csv']
        ,['lga_product','lga_product.csv']
        ,['bin','bin.csv']
        ,['product_point','product_point.csv']
    ]   
    

def db_connect(server_host,user_name,pw):
    con = mysql.connector.connect(
        host=server_host,
        user=user_name,
        password=pw
        #,database=DB_NAME
    )   
    return con 



def create_database(cursor):
    try:
        cursor.execute(
            "CREATE DATABASE IF NOT EXISTS {} DEFAULT CHARACTER SET 'utf8'".format(DB_NAME))
    except mysql.connector.Error as err:      
        print("Failed creating database: {}".format(err))
        #exit(1)

    try:
        cursor.execute("USE {}".format(DB_NAME))
    except mysql.connector.Error as err:
        print("Database {} does not exists.".format(DB_NAME))
        if err.errno == errorcode.ER_BAD_DB_ERROR:
            create_database(cursor)
            print("Database {} created successfully.".format(DB_NAME))
            cnx.database = DB_NAME
        else:
            print(err)
            exit(1)


def create_tables(cursor):
    for table_name in TABLES:
        table_description = TABLES[table_name]
        cursor.execute("DROP TABLE IF EXISTS {}".format(table_name))
        try:
            print("Creating table {}: ".format(table_name), end='')
            cursor.execute(table_description)
        except mysql.connector.Error as err:
            if err.errno == errorcode.ER_TABLE_EXISTS_ERROR:
                print(table_name,"already exists.")
            else:
                print(err.msg)
        else:
            print("OK")


def populate_tables(cur,con):
    for tab in table_sources: 
        table_name = tab[0]
        file_name = tab[1]
        print(tab)

        #get data from file
        data = pd.read_csv(file_name)

        #creating column list for insertion
        cols = "`,`".join([str(i) for i in data.columns.tolist()])

        #eMPTY TABLE
        cur.execute("DELETE FROM {}".format(table_name))

        # Insert DataFrame recrds one by one.
        for i,row in data.iterrows():
            sql = "INSERT INTO " + table_name + " (`" +cols + "`) VALUES (" + "%s,"*(len(row)-1) + "%s)"
            #print (sql)
            cur.execute(sql, tuple(row))

        # save changes
        con.commit()


def main():
    host="localhost"
    user="root"
    pw="1234"

    con  = db_connect(host,user,pw)
    cur = con.cursor()
    
    create_database(cur)
    create_tables(cur)
    populate_tables(cur,con)

    con.commit()
    con.close()

        
if __name__ == '__main__':
    main()

# import pymysql
# from sqlalchemy import create_engine

#from dbfread import DBF #for reading dbase files
#import sqlite3
#import json


# cur.execute("USE {}".format(DB_NAME))
# df_lga = pd.read_csv('lga_clean.csv')
# df_prod = pd.read_csv('product.csv')
# df_lga_prod = pd.read_csv('lga_product.csv')

# # # create sqlalchemy engine
# def db_engine(host,user,pw):
#     engine = create_engine("mysql+pymysql://{user}:{pw}@localhost/{db}"
#                         .format(user=user,
#                                 pw=pw,
#                                 db=DB_NAME)
#                             )



# def Createlga(cur,con):
        
#     CREATE_LGA_TABLE = """
#         create table lga
#         (
#         -- LG_PLY_PID TEXT   PRIMARY KEY  
#          LGA_PID   TEXT
#         ,LGA_NAME   TEXT 
#         ,primary key (LGA_PID)
#         )
#     """
#     cur.execute('DROP TABLE IF EXISTS lga') 
#     cur.execute(CREATE_LGA_TABLE)    
#     #cur.execute("create index idx_lga on lga (LGA_PID)")

#     df = lgaFromJson()
#     #df = lgaFromShape()

#     df.to_sql('lga', con, if_exists='append', index=False)




# def lgaFromJson():
    
#     with open("lga/lga.json") as file:
#         # Load its content and make a new dictionary
#         data = json.load(file)

#     lst_lga = []
#     for order in data["features"]:
#         #LG_PLY_PID = order['properties']['lg_ply_pid']
#         LGA_PID = order['properties']['lga_pid'] 
#         LGA_NAME = order['properties']['vic_lga__2'] 
#         lst_lga.append([LGA_PID,LGA_NAME]) #LG_PLY_PID,
    
#     df = pd.DataFrame(lst_lga, columns = ['LGA_PID','LGA_NAME']) #'LG_PLY_PID'
#     df = df.drop_duplicates()
#     return df


# def lgaFromShape():
#     #convert dbase to sqlite
#     dbf = DBF('vic_lga.dbf')
#     df = pd.DataFrame(iter(dbf))
#     df = df[['LG_PLY_PID','LGA_PID','LGA_NAME']]
#     return df



    #con = sqlite3.connect("lga.db")
    #cur = con.cursor()
    #Createlga(cur,con)
    #df = lgaFromJson()
    #df.to_csv('lga.csv')
    #print (df.head())
    # sql = 'select * from lga'
    # df = pd.read_sql(sql, con)
    # df.to_csv('lga.csv')


    # df_lga.to_sql('lga',con,if_exists='replace')
    # df_prod.to_sql('prod',con,if_exists='replace')
    # str_sql = """
    #     select 
    #            lga_pid
    #           ,product_id
    #           ,is_accepted_default is_accepted
    #      from lga,prod
    # """
    # df = pd.read_sql(str_sql, con)
    # df.to_csv('lga_product.csv')
    #print(df_lga.names())

    # Doing cartesian product of datasets 1 and 2 
    # df = pd.merge(df_lga.assign(key=0), df_prod.assign(key=0), 
    #              on='key').drop('key', axis=1)    
