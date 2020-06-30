from django.shortcuts import render
from django.http import HttpResponse

import base64
import cv2
import numpy as np
from .models import *

# Create your views here.
def home(request):
    # name = Student.objects.first().name
    return HttpResponse('xin chao')

def add(request):
    a = int(request.GET['a'])
    b = int(request.GET['b'])
    c = a + b
    return HttpResponse(str(c))

def add_std(request):
    std_id = request.GET['std_id']
    name = request.GET['name']
    fac_name = request.GET['fac_name']
    fac = Faculty.objects.get(name=fac_name)
    s = Student(std_id=std_id, name=name, faculty=fac)
    s.save()
    return HttpResponse('saved')
