from django.shortcuts import render
from django.http import HttpResponse
from django.views.decorators.csrf import csrf_exempt

import base64
import cv2
import numpy as np
import random
import string

from .models import *

# Create your views here.
def home(request):
    return HttpResponse('xin chao')

def add(request):
    a = int(request.GET['a'])
    b = int(request.GET['b'])
    c = a + b
    return HttpResponse(str(c))

def new_std(request):
    std_id = request.GET['std_id']
    name = request.GET['name']
    fac_name = request.GET['fac_name']
    fac = Faculty.objects.get(name=fac_name)
    s = Student(std_id=std_id, name=name, faculty=fac)
    s.save()
    return HttpResponse('saved')

@csrf_exempt
def upload_image(request):
    if request.method == 'POST':
        print(len(request.POST['image']))
        filename = handle_base64_str(request.POST['image'])
        return HttpResponse(filename)
    else:
        return HttpResponse('not supported')

def handle_base64_str(imgstring):
    filename = ''.join(random.choice(string.ascii_lowercase) for i in range(64)) + '.jpg'
    imgdata = base64.b64decode(imgstring)
    with open('images/'+filename, 'wb+') as destination:
            destination.write(imgdata)
    return filename
