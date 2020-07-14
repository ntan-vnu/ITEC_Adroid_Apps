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
        res = detect_face(filename)
        if res is None:
            return HttpResponse('-1 -1 -1 -1')
        return HttpResponse('%d %d %d %d'%(res[0], res[1], res[2], res[3]))
    else:
        return HttpResponse('not supported')

def detect_face(filename):
    img = cv2.imread(filename)
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    face_cascade = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')
    faces = face_cascade.detectMultiScale(
			gray,
			scaleFactor=1.1,
			minNeighbors=5,
			minSize=(30, 30),
			flags=cv2.CASCADE_SCALE_IMAGE
		)

    if len(faces) < 1:
        return None
    x, y, w, h = faces[0]
    img = cv2.rectangle(img, (x, y), (x+w, y+h), (0, 255, 0), 1)
    cv2.imwrite(filename, img)
    return faces[0]
    pass

def handle_base64_str(imgstring):
    filename = ''.join(random.choice(string.ascii_lowercase) for i in range(64)) + '.jpg'
    imgdata = base64.b64decode(imgstring)
    with open('images/'+filename, 'wb+') as destination:
            destination.write(imgdata)
    return filename
