import time
import random

random.seed(time.time())

separator = ';'
number_of_lines = 10000

first_names = ["Albert", "Roger", "Mathilde", "Benoit", "Marie", "Margaux", "Nathan", "Cyril", "François", "Jean", "Marc"]
names = ["Lepetit", "Jack", "Dugommier", "Wilson", "Hammon", "Macron", "Leforgeron", "Valls", "Ruffin", "Ben"]

def gen_num_sociale():
    gender = random.randrange(1, 3) # 3 est exclut
    year_birth = str(random.randrange(0, 9))+str(random.randrange(1, 10))
    month_birth = str(random.randrange(1, 13))
    month_birth = '0'+month_birth if len(month_birth) == 1 else month_birth
    dept_birth = str(random.randrange(1, 96))
    dept_birth = '0'+dept_birth if len(dept_birth) == 1 else dept_birth
    code_commune = str(random.randrange(1, 1000))
    if len(code_commune) == 1:
        code_commune = '00'+code_commune
    elif len(code_commune) == 2:
        code_commune = "0" + code_commune
    
    order_birth = str(random.randrange(1, 1000))
    if len(order_birth) == 1:
        order_birth = '00'+order_birth
    elif len(order_birth) == 2:
        order_birth = "0" + order_birth

    key_control = str(random.randrange(1, 100))
    key_control = '0'+key_control if len(key_control ) == 1 else key_control

    return f'{gender} {year_birth} {month_birth} {dept_birth} {code_commune} {order_birth} {key_control}'

with open('data.csv', 'w', encoding='utf-8') as file:
    file.write(f"index{separator}first_name{separator}name{separator}age{separator}numero_securite_sociale\n")
    for i in range(number_of_lines):
        name = random.choices(names)[0]
        first_name = random.choices(first_names)[0]
        age = random.randrange(1, 121)
        numero_securite_sociale = gen_num_sociale()
        file.write(f'{i+1}{separator}{first_name}{separator}{name}{separator}{age}{separator}{numero_securite_sociale}\n')
    file.close()

print("File created !")